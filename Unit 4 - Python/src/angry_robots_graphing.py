import matplotlib.pyplot as plt
import os

for file in os.listdir("../resources/angry_robots"):
    path = file
    v = file.split("-")[0][3:]
    a = file.split("-")[1][:-4]

    with open(f"../resources/angry_robots/{path}", "r") as f:
        points = map(
            lambda x: ((s := x.split("\n"))[0], s[1]),
            f.read().split("\n\n")[:-1]
        )

    points = [(float(x), float(y)) for x, y in points]
    points = points[:-1]
    x_points, y_points = zip(*points)

    plt.plot(
        x_points, y_points,
        marker="o",
        color="b",
    )
    plt.axis(
        [
            0,
            (m := max(x_points)) + (0.1 * m),
            0,
            (m := max(y_points)) + (0.1 * m)
        ]
    )
    plt.title(f"Angry Robots: v={v}, a={a}")
    plt.xlabel("Height (m)")
    plt.ylabel("Distance (m)")
    plt.grid()
    plt.show()
