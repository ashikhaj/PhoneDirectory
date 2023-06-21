class Node:
    def _init_(self, name, phone_number):
        self.name = name
        self.phone_number = phone_number
        self.next = None

class PhoneDirectory:
    def _init_(self):
        self.head = None

    def add_contact(self, name, phone_number):
        new_node = Node(name, phone_number)
        if self.head is None:
            self.head = new_node
        else:
            current = self.head
            while current.next:
                current = current.next
            current.next = new_node

    def search_contact(self, name):
        current = self.head
        while current:
            if current.name == name:
                return current.phone_number
            current = current.next
        return "Contact not found."

    def delete_contact(self, name):
        if self.head is None:
            return
        if self.head.name == name:
            self.head = self.head.next
            return
        current = self.head
        prev = None
        while current and current.name != name:
            prev = current
            current = current.next
        if current is None:
            return
        prev.next = current.next

    def display_contacts(self):
        current = self.head
        if current is None:
            print("Phone directory is empty.")
        else:
            while current:
                print(f"Name: {current.name}, Phone: {current.phone_number}")
                current = current.next

class PhoneStack:
    def _init_(self):
        self.stack = []

    def push(self, item):
        self.stack.append(item)

    def pop(self):
        if not self.is_empty():
            return self.stack.pop()
        else:
            return "Stack is empty."

    def is_empty(self):
        return len(self.stack) == 0


# Example usage:
directory = PhoneDirectory()
stack = PhoneStack()

while True:
    print("Phone Directory :")
    print("1. Add Contact")
    print("2. Search Contact")
    print("3. Delete Contact")
    print("4. Display Contacts")
    print("7. Exit")

    choice = int(input("Enter your choice: "))

    if choice == 1:
        name = input("Enter contact name: ")
        phone_number = input("Enter phone number: ")
        directory.add_contact(name, phone_number)
        print("Contact added.")

    elif choice == 2:
        name = input("Enter contact name to search: ")
        result = directory.search_contact(name)
        print(f"Phone number: {result}")

    elif choice == 3:
        name = input("Enter contact name to delete: ")
        directory.delete_contact(name)
        print("Contact deleted.")

    elif choice == 4:
        directory.display_contacts()

    elif choice == 5:
        name=input("enter the name to push:")
        phone_number = input("Enter phone number to push: ")
        stack.push(name)
        stack.push(phone_number)

        print("Phone number and name pushed to stack.")

    elif choice == 6:
        result = stack.pop()
        print(f"Popped phone num: {result}")
        result = stack.pop()
        print(f"Popped name: {result}")
    elif choice == 7:
        print("Exiting...")
        break

    else:
        print("Invalid choice. Please try again.")
