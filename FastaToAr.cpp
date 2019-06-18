#include <iostream>
#include <algorithm>
#include <fstream>
#include <string>
#include <map>
#include <vector>
#include "SixFrame.h"

using std::ifstream;
using std::cin;
using std::cout;
using std::endl;
using std::vector;
using std::string;
using std::next;

//hash table of Codons
	std::map<std::string, char> mapOfCodons = {
				{"TTT", 'F'},
				{"TTC", 'F'},
				{"TTA", 'L'},
				{"TTG", 'L'},
				{"TCT", 'S'},
				{"TCC", 'S'},
				{"TCA", 'S'},
				{"TCG", 'S'},
				{"TAT", 'Y'},
				{"TAC", 'Y'},
				{"TAA", '*'},
				{"TAG", '*'},
				{"TGT", 'C'},
				{"TGC", 'C'},
				{"TGA", '*'},
				{"TGG", 'W'},
				{"CTT", 'L'},
				{"CTC", 'L'},
				{"CTA", 'L'},
				{"CTG", 'L'},
				{"CCT", 'P'},
				{"CCC", 'P'},
				{"CCA", 'P'},
				{"CCG", 'P'},
				{"CAT", 'H'},
				{"CAC", 'H'},
				{"CAA", 'Q'},
				{"CAG", 'Q'},
				{"CGT", 'R'},
				{"CGC", 'R'},
				{"CGA", 'R'},
				{"CGG", 'R'},
				{"ATT", 'I'},
				{"ATC", 'I'},
				{"ATA", 'I'},
				{"ATG", 'M'},
				{"ACT", 'T'},
				{"ACC", 'T'},
				{"ACA", 'T'},
				{"ACG", 'T'},
				{"AAT", 'N'},
				{"AAC", 'N'},
				{"AAA", 'K'},
				{"AAG", 'T'},
				{"AGT", 'S'},
				{"AGC", 'S'},
				{"AGA", 'R'},
				{"AGG", 'R'},
				{"GTT", 'V'},
				{"GTC", 'V'},
				{"GTA", 'V'},
				{"GTG", 'V'},
				{"GCT", 'A'},
				{"GCC", 'A'},
				{"GCA", 'A'},
				{"GCG", 'A'},
				{"GAT", 'D'},
				{"GAC", 'D'},
				{"GAA", 'E'},
				{"GAG", 'E'},
				{"GGT", 'G'},
				{"GGC", 'G'},
				{"GGA", 'G'},
				{"GGG", 'G'}
	};

void print(vector<string> &vect){
	for(long long unsigned int i =0; i<vect.size(); i++){
		cout << vect[i] << endl;
	}
}

int main( ){
	string combined; //variable for each nucleotide sequence found
	string line; //variable for each line in the file
	vector<string> NucSeqs; //vector of strings will be the nucleotide sequences
	vector<string> RevStrandSeq; //another vector of the reverse strand
	ifstream myfile ("testing3.txt"); //file variable

	if(!myfile){
		cout<<"Error opening file to operate on"<<endl;
		system("pause");
		return -1;
	}
	while (getline(myfile, line))
	{
		if(line.at(0) != '>'){
			if(line.find(' ') != string::npos) line.erase(line.find(' ')); //removes any spaces
			combined += line; //append string to accumulated combined string
		}
		else{
			NucSeqs.push_back(combined);
			combined.clear();
		}
	}
	NucSeqs.push_back(combined);
	combined.clear();
	//Start of RevStrand operation
	for(auto& sec : NucSeqs){
		for(string::size_type i = 0; i<sec.size(); i++){
			if (sec[i] == 'C') combined += 'G'; //RevStrandSeq.push_back("G");
			if (sec[i] == 'G') combined += 'C'; //RevStrandSeq.push_back("C");
			if (sec[i] == 'A') combined += 'T'; //RevStrandSeq.push_back("T");
			if (sec[i] == 'T') combined += 'A'; //RevStrandSeq.push_back("A");
		}
		RevStrandSeq.push_back(combined);
		combined.clear();
	}
	//flip the sequence
	for(auto& Rev : RevStrandSeq){
		std::reverse(Rev.begin(), Rev.end());
	}
	printf("\n\nThe Forward Strand: ");
	print(NucSeqs);
	printf("The Reverse Strand: ");
	print(RevStrandSeq);
	printf("The final output is: \n");
	vector<string> out = SixFrame(mapOfCodons, NucSeqs);
	print(out);
}
