#Contact Manager

A **console-based Contact Manager** implemented in Java to practice **Low-Level Design (LLD)** and **Object-Oriented
Programming** concepts.  
The system supports basic **CRUD operations** and demonstrates **clean class separation and collection-based storage
design**.

# Problem Overview

Design a simple contact management system that allows a user to:

- Add a contact
- Delete a contact
- Update a contact
- Search for a contact
- Display all contacts

The application runs as a **menu-driven console program**.

# System Design

The system is divided into three main components:

Main (UI Layer)
↓
ContactService (Business Logic Layer)
↓
Contact (Entity / Model Layer)

### Responsibilities

| Component      | Responsibility                                |
|----------------|-----------------------------------------------|
| Main           | Handles user interaction and menu             |
| ContactService | Handles business logic and contact management |
| Contact        | Stores contact information                    |

# Class Diagram

```text
+----------------------+
|         Main         |
+----------------------+
| + main(args:String[])|
+----------------------+
           |
           | uses
           v
+-------------------------------+
|        ContactService         |
+-------------------------------+
| - contacts : Map<Character,   |
|             List<Contact>>    |
+-------------------------------+
| + ContactService()            |
| + addContact(name, phone)     |
|   : boolean                   |
| + deleteContact(name)         |
|   : boolean                   |
| + updateContact(oldName,      |
|   newName, newPhone)          |
|   : boolean                   |
| + searchContact(name)         |
|   : Contact                   |
| + displayContacts() : void    |
| - getBucketKey(name) : char   |
| - isDuplicatePhoneNumber(phone)|
|   : boolean                   |
| - isValidName(name) : boolean |
| - isValidPhoneNumber(phone)   |
|   : boolean                   |
+-------------------------------+
                |
                | manages
                v
+----------------------+
|       Contact        |
+----------------------+
| - name : String      |
| - phoneNumber:String |
+----------------------+
| + Contact(name,phone)|
| + getName() : String |
| + getPhoneNumber()   |
|   : String           |
| + setName(name)      |
| + setPhoneNumber(ph) |
| + toString() : String|
+----------------------+
```

Data Structure Used
Map<Character, List<Contact>>

Purpose:

Organizes contacts alphabetically

Groups contacts by first letter of the name

Improves readability while displaying contacts

Example:

A -> [Anita, Arun]
M -> [Madhu, Mohan]
P -> [Priya, Prakash]
R -> [Ravi]

Bucket key generation:

Character.toUpperCase(name.charAt(0))
Core Features

1. Add Contact

Adds a new contact with name and phone number.

Process:

1. Validate name
2. Validate phone number
3. Check duplicate phone number
4. Determine alphabetical bucket
5. Insert contact into bucket list
2. Delete Contact

Removes a contact using the name.

Process:

1. Determine bucket using first letter
2. Iterate through bucket list
3. Find matching contact
4. Remove from list
3. Update Contact

Allows updating:

name

phone number

Important design logic:

If the name changes from:

Madhu → Priya

Then the contact must move from:

Bucket M → Bucket P

4. Search Contact

Search algorithm:

1. Find bucket using first letter
2. Iterate through contacts in that bucket
3. Compare names (case-insensitive)
4. Return matching contact
5. Display Contacts

Prints contacts alphabetically.

Example output:

[M]
Name: Madhu, Phone: 9876543210

[P]
Name: Priya, Phone: 9123456789

Empty buckets are skipped.

Validations Implemented
Validation Reason
Name cannot be empty Prevent invalid contacts
Name must start with alphabet Avoid invalid bucket keys
Phone number must be 10 digits Basic phone validation
Duplicate phone numbers not allowed Prevent duplicate contacts

Phone validation example:

phoneNumber.matches("\\d{10}")
OOP Concepts Demonstrated
Encapsulation
private fields in Contact
public getters/setters
Separation of Concerns
Main -> UI logic
ContactService -> business logic
Contact -> data model
Abstraction

ContactService exposes methods like:

addContact()
deleteContact()
updateContact()
searchContact()

without exposing internal storage logic.

Collections Framework Usage

Uses:

Map
List
HashMap
ArrayList

for efficient storage and grouping.

Time Complexity

Add Contact

O(1)

Search Contact

O(n) within bucket

Delete Contact

O(n) within bucket

Update Contact

O(n)

Display Contacts

O(n)
Key Design Decisions (Interview Talking Points)
Why Map<Character, List<Contact>>?

organizes contacts alphabetically

improves display structure

reduces search space slightly

Why separate Service from Main?

cleaner architecture

follows Single Responsibility Principle

easier to maintain and extend

Limitations

Current system limitations:

contacts searched only by name

no email field

no persistent storage

duplicate names allowed

no sorting within buckets

Possible Improvements
Feature Improvements

Add:

email field

contact ID

search by phone number

edit email

sort contacts alphabetically

duplicate name prevention

Structural Improvements

Better storage options:

Map<String, Contact>   // key = phone number
Map<Integer, Contact>  // key = contactId

Advantages:

faster search

unique identifiers

easier updates