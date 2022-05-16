class Order:
    def __init__(
            self,
            client_name: str,
            item_names: list[str],
            item_quantities: list[int]
    ):
        self.client_name = client_name

        # store them as pairs in the dictionary AKA HashMap
        self.order_info = {
            name: amount for name, amount in zip(item_names, item_quantities)
        }

    def calculate_revenue(self) -> float:
        # quick lookup table for the prices
        prices = {
            "Sweet Potato": 0.5,
            "Idaho Potato": 0.4,
            "Squash": 0.75,
            "Tomato": 0.3,
            "Green Beans": 0.45,
        }

        total = 0
        for name, amount in self.order_info.items():
            total += prices[name] * amount

        return total

    def display_order(self):
        print(self.client_name)
        for name, amount in self.order_info.items():
            print(f"{amount} {name}")  # formatted string


class OrderHandler:
    # __init__ method is a python constructor. You can only have 1 per class.
    def __init__(self):
        self.orders = []

    def read_file(self, file_name: str):
        # this creates a file object named "f"
        # working with files is super easy in python
        # you may or may not have the same file path on your computer
        with open(f"../resources/Sales/{file_name}.txt", "r") as f:
            # 2 new lines seperate each order. .read() reads the string in
            # the file, .split() splits the string by every 2 new lines
            for order in f.read().split("\n\n"):
                # gets each line of the order in a list
                order = order.split("\n")

                # This removes and returns the first element in the array
                client_name = order.pop(0)

                # makes 2 lists, which alternate the elements from order
                names, counts = order[::2], order[1::2]

                counts = list(map(int, counts))  # converts the amounts to ints
                self.orders.append(Order(client_name, names, counts))

    def display_orders(self):
        for order in self.orders:
            order.display_order()
            print()  # new line

    def calculate_total_revenue(self):
        total = 0
        for order in self.orders:
            total += order.calculate_revenue()
        return total


# this would be in our main method if this was in java
test_handler = OrderHandler()

# input() prints a line and returns the next entered line
name = input("Which file should be read? (do not include .txt extension)\n")
test_handler.read_file(name)

print("\nOrders Read:")
test_handler.display_orders()

print(test_handler.calculate_total_revenue())
