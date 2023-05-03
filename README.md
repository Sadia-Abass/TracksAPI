#About - Track API 

In Radio Music Services (RMS) team we have a microservice architecture
(HTTP/RPC web services). We would like you to build a RESTful API as per the details
below.

##Instructions
design a RESTful JSON ‘Tracks’ API that:
* runs on a localhost port
* Processes ‘track’ objects fitting the format laid out below - we do not expect any data to be persisted, since this is a short test all data can be held in memory.
* has an endpoint to fetch a ‘track’ object by ID
* has an endpoint to add tracks - be mindful of what HTTP methods/headers would be involved and what an appropriate response would be when hitting this endpoint. Again, this can all still be handled in memory.
* Once a track has been added, the API allows you to retrieve that track using the endpoint created to fetch tracks with their ID.
* Returns a meaningful response when no results are returned.

##Language and Libraries used to build this project
Scala,
Http4s,
circe,
SBT

##How to run the project
Open a terminal and navigate to the project folder in the terminal then type ```sbt run```

##Personal Thoughts
Assumption is that given an API creation in production, the first thing was to create 
different package that will hold different component, looking at the data the API will be 
collecting and rendering.

Next thing was to start develop CRUD functionalities and the API endpoints.

###What is not implemented yet and what need to be done still
The project does not have an update function and as well as the API endpoint need to implement the logic for the function,
created a config server (not complete yet as it only work will local host) as it does not have any config related to a database, if
pne were to be used in production.