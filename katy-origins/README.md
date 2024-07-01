# katy_origins

minecraft origins datapack!!

## Dependencies

[nn_math](https://github.com/NOPEname/nn_math) by NOPEname

## katyorigins/powers

### wishdir.json

Tracks the direction the player wants to move and stores that in scoreboard variables `@s wishdir_x` and `@s wishdir_z`. These values are scaled by 10000 for decimal precision and the vector `<@s wishdir_x, @s wishdir_z>` is the player's input direction in world space.

### track_velocity.json

Tracks the velocity vector of the entity and stores that in scoreboard variables `@s velocity_x`, `@s velocity_y` and `@s velocity_z`. These values are scaled by 10000 for decimal precision.

## katymath/functions

### 2d_matrix_rotation.mcfunction

Does a 2D matrix rotation. Depends on nnmath/functions/trig.

Before calling the function, set the inputs:

`rotation_angle matrices`: Angle to rotate vector basis by

`in_x matrices`: Vector's X component

`in_y matrices`: Vector's Y component

## katyforces/functions

### add_force.mcfunction

Adds a force to the target entity using recursive calls to `/motion` until the desired force on each axis is reached. This allows us to use scoreboard variables
 to affect motion rather than literals. Currently only supports X and Z axis motion, although Y axis motion would be trivial to implement. There is a limit to
  the amount of iterations allowed meaning greater forces may not work properly for now.

Before calling the function, set the inputs:

`in_x forces`: Force X component

`in_Z forces`: Force Z component
