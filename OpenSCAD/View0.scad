linear_extrude(height = 10.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
{
    scale([10.0, 50.0])
    {
        M53();
    }
}

module M53()
{
    polygon
    (
        points =
        [
            [-0.5, -0.5], 
            [0.5, -0.5], 
            [0.5, 0.5], 
            [-0.5, 0.5]
        ],
        paths =
        [
            [0, 1, 2, 3]
        ]
    );
}
