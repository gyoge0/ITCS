grades = []


def display_grades():
    print("The grades are...")
    print(grades)


def add_grades():
    global grades
    print("Enter grades or -1 to stop")
    try:
        while (i := float(input("Grade: "))) != -1:
            grades.append(i)
    except ValueError:
        pass


def round_up_grades():
    global grades
    grades = list(map(lambda x: x + 1 if x in [69, 79, 89] else x, grades))


def get_average_grade():
    return sum(grades) / len(grades)


def remove_low_grade():
    grades.remove(min(grades))


add_grades()
round_up_grades()
remove_low_grade()
display_grades()
print(f"Average: {get_average_grade():.2f}")
