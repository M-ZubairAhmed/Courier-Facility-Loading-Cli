
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
`park XX YY`
<br>
*XX : Positive integers, denoting parcel code
<br>
YY : Positive integers, denoting parcel weight*
##### Dispatch goods
To dispatch good items from the rack shelf and prepare for delivery.
<br>
`leave X for delivery`
<br>
*X : Positive integer, denoting rack slot number*
