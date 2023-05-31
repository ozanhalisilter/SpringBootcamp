# Cohorts Homework 1

This Java application is designed to manage different types of houses - Apartments, Villas, and Summer Houses. It provides functionality to calculate total price, average square meter, filter houses based on room and saloon count for each type, and for all houses.

## Features

Add and maintain lists of Apartments, Villas, and Summer Houses.
Get total price for each type of houses and for all houses.
Get average square meter for each type of houses and for all houses.
Filter houses based on room and saloon count.
Fetch list of Apartments, Villas, and Summer Houses.
## Classes

### House
This is an abstract class which serves as the base for different types of houses. It defines the basic attributes common to all types of houses such as price, square meter, number of rooms, and number of saloons.

### Apartment, Villa, SummerHouse
These are concrete classes that extend the House class and represent specific types of houses.

### HouseService
This class provides the core functionality of the application. It maintains lists of different types of houses and provides methods to add houses, calculate total price and average square meter, filter houses based on room and saloon count, and fetch list of houses.