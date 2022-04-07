# IMPLEMENTATION OF HAVERSINE, DIJKSTRA’S ALGORITHM, AND  SARIMAX FOR PHILIPPINE TRANSPORT AND  FARE COLLECTION SYSTEM
Group Members: 

Salcedo, Audrey B. 

Recabar, Bea Merr S.

Santisteban, Tina Marie F. 

Darle, Clarice Jane D.

# SYNOPSIS

The proposed system focused on the implementation of the  mobile application called the EzPay app intended for buses,  taxis, and jeepneys here in Iloilo. The Ezpay app has the  feature to visualize how a pathfinding algorithm works using  Dijkstra's Algorithm and to generate QR code. The Haversine  Algorithm was used when calculating the distance traveled and  the fare was based on the LTFRB regulation’s fare tariff.  On the other hand, Places API was used to get the coordinates.  The proponents also proposed the Top-up system which allowed  users to add load value and check the balance for the existing  users.

# MOTIVATION

The proposed systems were implemented for better fare payment  and minimization of physical contact of all target users as  well as for the improvement of the transportation system here  in Iloilo. Faster, safer, and accurate fare collection is what the proponents are aiming for.

# INSTALLATION

Clone the repository 

To view the compiled program for Mobile Application:

    src/ezpay_mobileapp

To view the compiled program for Fare Management System

    src/faremanagement_system

To view the compiled program for Top-up System

    src/topup_system
    
To check the credentials of the developed system: 

    keys/keys.txt

# API REFERENCE

For Google Maps API Key

Before you start using the Places API, you need a project with a billing account and the Places API is enabled. 

Refer to this documentation link on how to create a new Google Cloud Project(https://developers.google.com/maps/documentation/places/web-service/cloud-setup).

With the link provided you can see the detailed instruction on how to create a new Google Cloud Project.

Refer to this link for a detailed instruction:
(https://developers.google.com/maps/documentation/places/web-service/get-api-key)

You can also refer to this tutorial video on how to generate and restrict API keys for Google Maps Platform:
(https://www.youtube.com/watch?v=2_HZObVbe-g&t=1s)

# MODIFYING THE MOBILE APPLICATION

### TESTING THE GOOGLE MAPS API:

Place your API KEY in the Passenger_Calculator file:

    //Initialize Places   
    Places.initialize(getApplicationContext(), "PLACE YOUR API KEY HERE");

### TESTING THE GOOGLE MAPS API:

Put the URL of your own database in StringRequest

    StringRequest request = new StringRequest(Request.Method.POST, url,
   	new Response.Listener<String>() {
	….
	}

For reference:

https://google.github.io/volley/simple.html?fbclid=IwAR3l0JAY7GC_fJGpSh4137TZ7da_yGDiKu9zPYU8H-ypBR1xx7BzZBujB_o

# MODIFYING THE TOP-UP AND FARE COLLECTION SYSTEM

To change the Database Connection input your own credential on every getConnection() method. 

    conn = DriverManager.getConnection("url/dbname, username,password ");

# SARIMAX SIMULATION
The forecasting of the sales with the use of Seasonal  Autoregressive Integrated Moving Average Exogenous (SARIMAX)  model. 

To change the dataset

    df = pd.read_csv("putyourdatasethere")
    
for the simulation of the SARIMAX you can open and run this file: 
    
    sarimapredication2.py

Once you are done testing the SARIMAX code it will generate images, to upload the image in the sql you can run the: 

    sql.py
    
To change the database connection

    db = mysql.connector.connect(
        host = " ",
        user = " ",
        password = " ",
        database = " "     
        )
