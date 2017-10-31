Coding Test

Build a list view using the following data feed:

https://aboutdoor.info/news?index=0

Display only headline and image for each item.

This API gives a list of 10 items at once, with an offset specified by the index query parameter. 
Your list view should display 10 rows of data initially, but when the user scrolls to the bottom of the list it should automatically load more data and add it to the list view.

Assume there is an unreasonably large number of items available.

===============================================================================================================================

This app is based on MVP pattern. It uses Retrofit2 with RxJava2 to fetch network data asynchronously. This app also
uses Glide library to load and cache the image.
The app contains 5 packages:
1. UI - Contains Main activity with it's "view" and an adapter class to populate the list view inside the activity.
2. Presenter - Presenter provides an isolation between UI and Network Requests.
3. Model - Model class which is used to collect the data from the network.
4. Retrofit - For network related operations.
5. Glide - For image handling.

