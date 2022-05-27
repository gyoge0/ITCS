import aiohttp
import asyncio


async def get_files(name: str):
    async with aiohttp.ClientSession() as session:
        async with session.get(f"https://leff-itcs.s3.amazonaws.com/{name}") as resp:
            return await resp.text()


def _main():
    name = None
    while name not in (
        "AprilSales.txt",
        "MaySales.txt",
        "JuneSales.txt",
        "JulySales.txt",
    ):
        name = input("Enter name of file (include.txt extension): ")

    text = asyncio.run(get_files(name))
    orders = text.replace("\r", "\n")
    orders = orders.split("\n\n\n")
    orders = orders[:-1]
    orders = list(map(lambda x: x.split("\n\n")[1:], orders))
    orders = [item for order in orders for item in order]
    orders = zip(orders[::2], orders[1::2])
    items = {
        "Sweet Potato": 0.00,
        "Idaho Potato": 0.00,
        "Squash": 0.00,
        "Tomato": 0.00,
        "Green Beans": 0.00,
    }

    for item, amount in orders:
        items[item] += int(amount)

    costs = {
        "Sweet Potato": 0.50,
        "Idaho Potato": 0.40,
        "Squash": 0.75,
        "Tomato": 0.30,
        "Green Beans": 0.45,
    }

    print("\nTotal items to be delivered:")
    for item in items:
        print(f"{item}: {items[item]:.0f}")
        items[item] = items[item] * costs[item]
    print("\nTotal Revenue:")
    print(sum(items.values()))


if __name__ == "__main__":
    asyncio.set_event_loop_policy(asyncio.WindowsSelectorEventLoopPolicy())
    _main()
