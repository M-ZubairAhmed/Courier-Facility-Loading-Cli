
# Courier Facility Loading
A command line java program to keep track of goods loading and unloading in storage racks


## Requirements
Program should provide with an interactive command prompt based shell where commands can be typed in.

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