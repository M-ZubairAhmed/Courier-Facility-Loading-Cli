
# Courier Facility Loading
A command line java program to keep track of goods loading and unloading in storage racks

## Problem Statement
We own a courier facility which segregate the courier for different cities into
different racks that can hold up to 'n' packages at any given point in time.
Each level in the rack has 2 slots. The slots is given a number first to all in
one column starting at 1 increasing with increasing level from the entry point
in steps of one till n/2 and then to the second column as n/2+1 at the of the
topmost level decreasing by 1 at each lower level. We want to create an
automated ticketing system that allows my facility man to use my allotted slot
without any error.

Eg: if I have a rake with 10 slots, the arrangement will be like:

|    	|   	|
|---	|----	|
| 5 	| 6  	|
| 4 	| 7  	|
| 3 	| 8  	|
| 2 	| 9  	|
| 1 	| 10 	|

When a parcel enters my racks, we want to have a ticket issued to the parcel.
The ticket issuing process includes us documenting the parcel code and
the weight(in gm) of the parcel and allocating an available slot to the parcel
before actually handing over a ticket to the facility man(we assume that our facility men are nice enough to always park in the slots
allocated to them). The Parcel should be allocated a slot which is nearest
to the entry. At the exit the customer returns the ticket which
then marks the slot they were using as being available.

## Requirements
- Program should provide with an interactive command prompt based shell where commands can be typed in.
-   The system should provide me with the ability
to find out:
    - Parcel codes of all parcels of a particular weight.
    * Slot number in which a parcel with a given code is parked.
    * Slot numbers of all slots where a parcel of a particular weight is parked.

## Shell commands

##### Create Rack shelf
To new rack shelf in the facility
<br> 
`create_parcel_slot_lot X`
<br>
*X : Positive integer denoting rack size*
##### Store goods
To store good items in the rack shelf
<br>
`park X Y`
<br>
*X : Positive integer, denoting parcel code
<br>
Y : Positive integer, denoting parcel weight*
##### Dispatch goods
To dispatch good items from the rack shelf and prepare for delivery.
<br>
`leave X for delivery`
<br>
*X : Positive integer, denoting rack slot number*
##### Search in rack
###### With weights
`slot_numbers_for_parcels_with_weight X`
<br>
*X : Positive integer, denoting parcel weight*
###### With parcel code
`slot_number_for_registration_number Y`
<br>
*Y : Positive integers, denoting parcel code*
##### Display Rack
Shows the racks content in a table
`status`

### Example Run
Assuming a parcel slot with 6 slots, the following commands should be run
in sequence by typing them in at a prompt and should produce output as
described below the command:
##### 1 
###### Input:
`create_parking_lot 6`
###### Output:
`Created a parcel slot with 6 slots`

##### 2 
###### Input:
`park 1234 400`
###### Output:
`Allocated slot number: 1`
##### 3 
###### Input:
`park 9999 400`
###### Output:
` Allocated slot number: 6`
##### 4
###### Input:
`park 0001 600`
###### Output:
`Allocated slot number: 2`
##### 5
###### Input:
`park 7777 100`
###### Output:
`Allocated slot number: 5`
##### 6
###### Input:
`park 2701 700`
###### Output:
`Allocated slot number: 3`
##### 7
###### Input:
`park 3141 600`
###### Output:
`Allocated slot number: 4`
##### 8
###### Input:
`leave 5 for delivery`
###### Output:
`Slot number 5 is free`
##### 9
###### Input:
`status`
###### Output:
| Slot No 	| Registration No 	| Weight 	|
|---------	|-----------------	|--------	|
| 1       	| 1234            	| 400    	|
| 6       	| 9999            	| 400    	|
| 2       	| 0001            	| 600    	|
| 3       	| 2701            	| 700    	|
| 4       	| 3141            	| 600    	|
##### 10
###### Input:
`park 333 400`
###### Output:
`Allocated slot number: 5`
##### 11
###### Input:
`park 9999 400`
###### Output:
`Sorry,parcel slot is full`
##### 12
###### Input:
`parcel_code_for_parcels_with_weight 400`
###### Output:
`1234, 9999, 333`
##### 13
###### Input:
`slot_numbers_for_parcels_with_weight 400`
###### Output:
`1, 6, 5`
##### 14
###### Input:
`slot_number_for_registration_number 3141`
###### Output:
`4`
##### 15
 ###### Input:
`slot_number_for_registration_number 1111`
###### Output:
`Not found`
