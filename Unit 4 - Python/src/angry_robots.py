import math  # math isn't imported by default
import matplotlib.pyplot as plt

# constants
# convention is all caps name at top of file
AX = 0
DT = 0.02

planets = {
    "mercury": -3.7,
    "venus": -8.87,
    "earth": -9.8,
    "moon": -1.62,
    "mars": -3.721,
    "jupiter": -24.79,
    "saturn": -10.44,
    "uranus": -8.87,
    "neptune": -11.15,
    "pluto": -0.62,
}

planet = input("Enter planet: ").lower().split()[0]
if planet not in planets.keys():
    planet = "earth"
print(f"Using planet: {planet}")
ay = planets[planet]

v0 = float(input("Enter the initial velocity (m/s): "))
angle = float(input("Enter the launch angle (degrees): "))


def calculate_v0x(v0, angle):
    return v0 * math.cos(math.radians(angle))


def calculate_v0y(v0, angle):
    return v0 * math.sin(math.radians(angle))


v0x = calculate_v0x(v0, angle)
v0y = calculate_v0y(v0, angle)

print(f"v0x = {v0x:.6f}\tv0y = {v0y:.6f}")


def calculate_x(v0x, t):
    return v0x * t  # no acceleration in x direction


def calculate_y(v0y, t):
    return v0y * t + (0.5 * ay * (t ** 2))


# helper function to return our points
# we can reuse this later
def _calculate_points(ang):
    t = 0
    points = []
    while True:
        v0y = calculate_v0y(v0, ang)
        v0x = calculate_v0x(v0, ang)

        y = calculate_y(v0y, t)
        x = calculate_x(v0x, t)
        if y < 0:
            break

        t += DT

        points.append((x, y))

    return points


def calculate_projectile():

    points = _calculate_points(angle)

    plt.scatter(*zip(*points), 9)
    plt.title(f"Angry Robots: v0={v0} angle={angle}")
    plt.xlabel("x (m)")
    plt.ylabel("y (m)")
    plt.show()  # this shows the graph


calculate_projectile()


def optimal_angle():
    best, ang = -1, -1
    for angle in range(90):
        # its inefficient, but our computers are powerful enough to do this
        x = _calculate_points(angle)[-1][0]

        if x > best:
            best, ang = x, angle

    assert ang != -1  # make sure we found an angle
    return ang


angle = optimal_angle()
print(f"Optimal angle: {angle}")


def plot_all(angle):
    # define our offsets
    sets = [-30, -15, 0, 15, 30]

    # add the angle to each offset
    sets = map(lambda x: x + angle, sets)

    # we don't want points going backwards
    sets = filter(lambda x: 0 <= x <= 90, sets)

    # calculate points for each offset angle
    sets = map(_calculate_points, sets)

    # zip the sets with colors, so we can iterate over them at the same time
    sets = zip(sets, ("teal", "firebrick", "darkorange", "darkgreen", "navy"))

    for points, color in sets:
        plt.scatter(*zip(*points), 9, c=color)

    plt.title(f"Angry Robots: v0={v0}   angle={angle}")
    plt.xlabel("x (m)")
    plt.ylabel("y (m)")
    plt.show()


plot_all(angle)
