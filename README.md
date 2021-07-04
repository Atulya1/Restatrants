# Restaurants


Mode of Transportation can be "by Walking", "by Car", "by bike", "public transportation" etc. All these modes can take different routes and can have different comparative distance and respective time taken to travel. In order to make it more Object oriented, I would make another class where I will take that into account. In future, we can add modes of transportation if required. 

For the problem statement where I need to find the shorted alternate route, it can only be implemented with proper data set which can be obtained from the Google Maps API for which I don't have access for the time being.   


Apis- 

Get -
1. http://localhost:8080/location/getMyLocation
2. http://localhost:8080/location/getNearByRestaurantLocation
3. http://localhost:8080/distance/getAllRestaurantNearBySortedByDistance
4. http://localhost:8080/distance/getNearestAndFarthestRestaurant
5. http://localhost:8080/distance/getNearestAndFarthestRestaurantByCar
6. http://localhost:8080/getAnswers/getArea
7. http://localhost:8080/getAnswers/getAreaByCar
8. http://localhost:8080/getAnswers/getTime/{speed}
9. http://localhost:8080/getAnswers/getTimeByCar/{speed}


Post -
1. http://localhost:8080/location/saveMyLocation
2. http://localhost:8080/location/saveNearByRestaurantLocation
