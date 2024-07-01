execute as @s if score in_x forces > approx_zero constants run motion add @s 0.01 0 0
execute as @s if score in_x forces > approx_zero constants run scoreboard players operation in_x forces -= one_hundredth constants

execute as @s if score in_x forces < approx_negative_zero constants run motion add @s -0.01 0 0
execute as @s if score in_x forces < approx_negative_zero constants run scoreboard players operation in_x forces += one_hundredth constants

execute as @s if score in_z forces > approx_zero constants run motion add @s 0 0 0.01
execute as @s if score in_z forces > approx_zero constants run scoreboard players operation in_z forces -= one_hundredth constants

execute as @s if score in_z forces < approx_negative_zero constants run motion add @s -0 0 -0.01
execute as @s if score in_z forces < approx_negative_zero constants run scoreboard players operation in_z forces += one_hundredth constants

scoreboard players add iterations forces 1

execute as @s if score iterations forces < max_iterations constants run function katyforces:add_force_recursive