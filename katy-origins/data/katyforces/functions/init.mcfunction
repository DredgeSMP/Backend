scoreboard objectives add forces dummy

scoreboard objectives add constants dummy
scoreboard players set max_iterations constants 25
scoreboard players set approx_zero constants 100
scoreboard players set approx_negative_zero constants -100
scoreboard players set one_hundredth constants 100

tellraw @a "katyforces has been loaded!"