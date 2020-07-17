#!/bin/bash 

input=$1 #protein DB
output=$2 #spectra file
numSpectra=$3 #no. of spectra

temp1=digestorOut.fasta
temp2=simOut.ms2

Digestor -in $input -out $temp1 -missed_cleavages 2 -min_length 7 -max_length 50 -threads 16

 

sed -i '/>/d' ./$temp1

 

#use head to get specific numbers of spectra

if [ "$numSpectra" -gt 0 ]; then

#             head -n$numSpectra $temp1 >  temp.txt; mv temp.txt $temp1

                shuf -n $numSpectra $temp1 > temp.txt; mv temp.txt $temp1

fi

 

sed -i 's/U/G/g' $temp1

sed -i 's/X/G/g' $temp1

 

java -cp /home/jquit001/MaSS-Simulator/bin SimSpec 1 1 $temp1 $temp2 /home/jquit001/MaSS-Simulator/bin/params.txt /home/jquit001/MaSS-Simulator/bin/modifications.ptm

 

rm $temp1

 

msconvert $temp2 --mgf -z --outfile $output --filter "msLevel 2"

#FileConverter -in $temp2 -out $output -threads 165

 

#rm $temp2

 

sed -i '/^[[:space:]]*$/d' $output


