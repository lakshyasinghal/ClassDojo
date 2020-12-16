#!/bin/bash

folders=( "http" )

cd src/main/java

for i in "${folders[@]}"
	do
		mv $i/com/myNetwork $i/com/classDojo
	done
