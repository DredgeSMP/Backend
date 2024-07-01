# calc horizontal velocity vector
execute as @s store result score current_x temp_variables run data get entity @s Pos[0] 10000
scoreboard players operation @s velocity_x = current_x temp_variables
scoreboard players operation @s velocity_x -= @s last_pos_x
scoreboard players operation @s last_pos_x = current_x temp_variables

execute as @s store result score current_z temp_variables run data get entity @s Pos[2] 10000
scoreboard players operation @s velocity_z = current_z temp_variables
scoreboard players operation @s velocity_z -= @s last_pos_z
scoreboard players operation @s last_pos_z = current_z temp_variables

execute as @s store result score current_y temp_variables run data get entity @s Pos[1] 10000
scoreboard players operation @s velocity_y = current_y temp_variables
scoreboard players operation @s velocity_y -= @s last_pos_y
scoreboard players operation @s last_pos_y = current_y temp_variables

# calc and store vector magnitude
scoreboard players operation in0.x nnmath_vec = @s velocity_x
scoreboard players operation in0.y nnmath_vec = @s velocity_z

function nnmath:vec/2/get_length/exe
scoreboard players operation @s xz_speed = out nnmath_vec