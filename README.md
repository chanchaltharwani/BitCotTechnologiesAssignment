# Bitcot Technologies Assignment

## Overview

This is an Android application that fetches TV show data from a remote API and displays it in a RecyclerView. Users can search for TV shows by genre using the SearchView. The app follows the MVVM architecture and uses Retrofit for network operations.

## Architecture

The app follows the MVVM (Model-View-ViewModel) architecture:
- *Model*: Contains data classes for the TV shows.
- *View*: Activities and XML layouts that display the data.
- *ViewModel*: Manages UI-related data and handles business logic.

## Design Decisions

- *MVVM Architecture*: To separate concerns and make the code more maintainable.
- *Retrofit*: For network operations because of its ease of use and efficiency.
- *DataBinding*: To bind UI components in layouts to data sources.
- *RecyclerView*: To display a list of TV shows.

## Instructions for Running the Application

1. Clone the repository:
   ```sh
   git clone https://github.com/chanchaltharwani/BitCotTechnologiesAssignment.git
