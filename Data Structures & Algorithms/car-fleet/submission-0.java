class Car {
    private int position;
    private int speed;

    public Car(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }

    public int getPosition() {
        return position;
    }

    public int getSpeed() {
        return speed;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < position.length; i++) {
            Car car = new Car(position[i], speed[i]);

            cars.add(car);
        }

        cars.sort((a, b) -> Integer.compare(b.getPosition(), a.getPosition()));

        Stack<Car> fleets = new Stack<>();

        for (Car car : cars) {
            double arrivalTime = (double) (target - car.getPosition()) / car.getSpeed();

            double topFleetArrivalTime = 0;

            if (!fleets.isEmpty()) {
                topFleetArrivalTime = (double) (target - fleets.peek().getPosition()) / fleets.peek().getSpeed();
            }

            if (fleets.isEmpty()) {
                fleets.push(car);
            } else if (arrivalTime > topFleetArrivalTime) {
                fleets.push(car);
            }
        }

        return fleets.size();
    }
}









