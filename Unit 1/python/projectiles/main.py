import math


class AngryRobots:
    def __init__(self, **kwargs):
        self.VI: float = kwargs.get("vi", 0.0)

        self.ANG: int = kwargs.get("angle", 60)

        self.VIX = self.calc_vix(self.ANG)
        self.VIY = self.calc_viy(self.ANG)

        self.OPTIMAL_ANG: int = 45

        gravities: dict[str, float] = {
            "mercury": 3.697,
            "venus": 8.858,
            "earth": 9.8,
            "mars": 3.711,
            "jupiter": 24.79,
            "saturn": 10.44,
            "uranus": 8.895,
            "neptune": 11.15,
            "pluto": 0.58,
            "moon": 1.62,
        }
        self.AY: float = gravities[kwargs.get("ay", "earth")]

        self.TIME_INCREMENT: float = kwargs.get("increment", 0.1)

    def run(self):
        # Log values
        with open(
            r"C:\Users\875367\Code\ITCS\Unit 1\python\projectiles\output.txt", "w"
        ) as f:
            f.truncate(0)
            f.write(f"VI: {self.VI}\n")
            f.write(f"VIX: {self.VIX}\n")
            f.write(f"VIY: {self.VIY}\n")
            f.write(f"ANG: {self.ANG}\n")
            f.write(f"AY: {self.AY}\n")
            f.write(f"TIME_INCREMENT: {self.TIME_INCREMENT}\n")
        
        self.calc_projectile()
        self.calc_optimal_angle()
        self.plot_related_angles()

    # TODO: implement this
    def calc_projectile(self) -> None:
        """
        Plots the trajectory of a projectile with matplotlib
        """
        pass

    # TODO: implement this
    def calc_optimal_angle(self) -> None:
        """
        Calculates the optimal angle for a projectile.

        The optimal angle should be 45 deg. This method brute forces it to find the angle.
        """
        pass

    # TODO: implement this
    def plot_related_angles(self) -> None:
        """
        Plots related angles to the optimal angle.

        Plots the optimal angle, angles +/- 15 degrees, and angles +/- 30 degrees.
        """
        pass

    def calc_vix(self, ang: float) -> float:
        return self.VI * math.cos(math.radians(ang))

    def calc_viy(self, ang: float) -> float:
        return self.VI * math.sin(math.radians(ang))


def main():
    kwargs = {}

    # Get values for vi, angle, planet (ay), and increment
    while True:
        try:
            kwargs["vi"] = float(input("Enter an initial velocity: "))
            break
        except ValueError:
            print("Invalid input. Initial velocity must be a number.")

    while True:
        try:
            kwargs["angle"] = float(input("Enter an angle: "))
            break
        except ValueError:
            print("Invalid input. Angle must be an integer.")

    kwargs["planet"] = input("Enter a planet: ").lower()

    while True:
        try:
            kwargs["increment"] = float(input("Enter a time increment: "))
            break
        except ValueError:
            print("Invalid input. Time increment must be a number.")

    red = AngryRobots(**kwargs)
    print(red.TIME_INCREMENT)
    red.run()


if __name__ == "__main__":
    main()
