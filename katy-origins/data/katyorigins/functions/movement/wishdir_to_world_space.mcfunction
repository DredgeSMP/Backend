# get the player's angle of rotation (in degrees, scaled by 100)
execute as @s store result score rotation_angle matrices run data get entity @s Rotation[0] 100
execute as @s store result score in_x matrices run resource get @s katyorigins:wishdir_wishx
execute as @s store result score in_y matrices run resource get @s katyorigins:wishdir_wishz

# normalization hack we can get away with because we dont have analog inputs, 0.707 is approx. equal to (1 / √2)
execute if score @s in_y > zero constants run scoreboard players operation @s in_x *= 0.707
execute if score @s in_x > zero constants run scoreboard players operation @s in_y *= 0.707

function katymath:2d_matrix_rotation

scoreboard players operation @s wishdir_x = out_x matrices
scoreboard players operation @s wishdir_z = out_y matrices
