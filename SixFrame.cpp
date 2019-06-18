#include <string>
#include <map>
#include <vector>
#include <iterator>
#include "SixFrame.h"

using std::vector;
using std::map;
using std::string;

vector<string> SixFrame(std::map<string, char> &codonChart, vector<string> &vect){
	vector<string> Codon;
	string combined;
	int i= 0;
	for(auto& sec : vect){
		for (auto const& element : codonChart){
			if(sec.substr(i, 3) == element.first){
				combined += (element.second);
			}
			i+=3;
		}
		Codon.push_back(combined);
		combined.clear();
	}

	return Codon;

}
