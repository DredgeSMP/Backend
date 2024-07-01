# matrix multiplication to rotate basis. i ♥ math
# wiki article:             https://en.wikipedia.org/wiki/Rotation_matrix 
# visualization/calculator: http://matrixmultiplication.xyz/

# the expression we want to evaluate...
# [ cos(yaw) -sin(yaw) ][ x ]
# [ sin(yaw)  cos(yaw) ][ y ]

# ...boils down to this after matrix multiplication:
# x = [ x * cos_yaw - y * sin_yaw ] 
# y = [ x * sin_yaw + y * cos_yaw ]

# this trig stuff should be the only expensive operation besides maybe the above nbt query, 
# everything else doesnt invoke any divisions or square roots or anything

# our input
scoreboard players operation in nnmath_trig = rotation_angle matrices

# we use cos_bs and sin_bs because it uses the same fixed point scale as we do, 10,000

# cos(yaw)
function nnmath:trig/cos_bs/exe 
scoreboard players operation cos_yaw matrices = out nnmath_trig 

# sin(yaw)
function nnmath:trig/sin_bs/exe
scoreboard players operation sin_yaw matrices = out nnmath_trig 

# prepare our memory addresses
scoreboard players operation x_cos_yaw matrices = cos_yaw matrices
scoreboard players operation z_sin_yaw matrices = sin_yaw matrices

scoreboard players operation x_sin_yaw matrices = sin_yaw matrices
scoreboard players operation z_cos_yaw matrices = cos_yaw matrices

# build our terms
# (x * cos_yaw)
scoreboard players operation x_cos_yaw matrices *= in_x matrices
# (y * sin_yaw)
scoreboard players operation z_sin_yaw matrices *= in_y matrices

# (x * sin_yaw)
scoreboard players operation x_sin_yaw matrices *= in_x matrices
# (y * cos_yaw)
scoreboard players operation z_cos_yaw matrices *= in_y matrices

# out_x = [ (x * cos_yaw) - (y * sin_yaw) ] 
#       = [    x_cos_yaw  -   z_sin_yaw   ] 
scoreboard players operation out_x matrices = x_cos_yaw matrices
scoreboard players operation out_x matrices -= z_sin_yaw matrices

# out_y = [ (x * sin_yaw) + (y * cos_yaw) ]
#       = [   x_sin_yaw   +   z_cos_yaw   ]
scoreboard players operation out_y matrices = x_sin_yaw matrices
scoreboard players operation out_y matrices += z_cos_yaw matrices

# out is hopefully now rotated from in by the rotation_angle
# now you can pick up anything