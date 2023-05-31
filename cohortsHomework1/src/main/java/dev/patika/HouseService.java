package dev.patika;

import entity.Apartment;
import entity.House;
import entity.SummerHouse;
import entity.Villa;

import java.util.ArrayList;
import java.util.List;

public class HouseService {
    private List<House> apartments;
    private List<House> villas;
    private List<House> summerHouses;

    HouseService() {
        apartments = new ArrayList<>();
        villas = new ArrayList<>();
        summerHouses = new ArrayList<>();

        // Adding example houses
        apartments.add(new Apartment(100000, 100, 3, 1));
        apartments.add(new Apartment(150000, 150, 4, 1));
        apartments.add(new Apartment(200000, 200, 5, 2));

        villas.add(new Villa(500000, 300, 5, 2));
        villas.add(new Villa(600000, 400, 6, 3));
        villas.add(new Villa(700000, 500, 7, 4));

        summerHouses.add(new SummerHouse(300000, 200, 4, 2));
        summerHouses.add(new SummerHouse(350000, 250, 5, 3));
        summerHouses.add(new SummerHouse(400000, 300, 6, 4));
    }

    public List<House> getApartmentList() {
        return new ArrayList<>(apartments);
    }

    public List<House> getVillaList() {
        return new ArrayList<>(villas);
    }

    public List<House> getSummerHouseList() {
        return new ArrayList<>(summerHouses);
    }
    public double getTotalPriceForApartments() {
        return apartments.stream().mapToDouble(House::getPrice).sum();
    }

    public double getTotalPriceForVillas() {
        return villas.stream().mapToDouble(House::getPrice).sum();
    }

    public double getTotalPriceForSummerHouses() {
        return summerHouses.stream().mapToDouble(House::getPrice).sum();
    }

    public double getTotalPriceForAll() {
        return getTotalPriceForApartments() + getTotalPriceForVillas() + getTotalPriceForSummerHouses();
    }

    public double getAverageSquareMeterForApartments() {
        return apartments.stream().mapToDouble(House::getSquareMeter).average().orElse(0);
    }

    public double getAverageSquareMeterForVillas() {
        return villas.stream().mapToDouble(House::getSquareMeter).average().orElse(0);
    }

    public double getAverageSquareMeterForSummerHouses() {
        return summerHouses.stream().mapToDouble(House::getSquareMeter).average().orElse(0);
    }

    public double getAverageSquareMeterForAll() {
        double totalSquareMeter = apartments.stream().mapToDouble(House::getSquareMeter).sum()
                + villas.stream().mapToDouble(House::getSquareMeter).sum()
                + summerHouses.stream().mapToDouble(House::getSquareMeter).sum();
        double totalCount = apartments.size() + villas.size() + summerHouses.size();

        return totalSquareMeter / totalCount;
    }

    public List<House> filterHousesByRoomAndSaloon(int rooms, int saloons) {
        List<House> filteredHouses = new ArrayList<>();

        filteredHouses.addAll(filterHouseListByRoomAndSaloon(apartments, rooms, saloons));
        filteredHouses.addAll(filterHouseListByRoomAndSaloon(villas, rooms, saloons));
        filteredHouses.addAll(filterHouseListByRoomAndSaloon(summerHouses, rooms, saloons));

        return filteredHouses;
    }

    private List<House> filterHouseListByRoomAndSaloon(List<House> houseList, int rooms, int saloons) {
        List<House> filteredHouses = new ArrayList<>();

        for (House house : houseList) {
            if (house.getRooms() == rooms && house.getSaloons() == saloons) {
                filteredHouses.add(house);
            }
        }

        return filteredHouses;
    }
}
