#include <vector>
#include <iterator>
#include <sstream>
#include <iostream>
#include <algorithm>
 
using namespace std;
 
void distribute(int dist, vector<int> &List) {
    if (dist > List.size() )
        List.resize(dist); 
 
    for (int i=0; i < dist; i++)
        List[i]++;
}
 
vector<int> abacus_sort(int *myints, int n) {
    vector<int> list, list2, fifth (myints, myints + n);
 
    for (int i=0; i < fifth.size(); i++)
        distribute (fifth[i], list);

    for (int i=0; i < list.size(); i++)
        distribute (list[i], list2);

    std::reverse(list2.begin(), list2.end());
    return list2;
}
 
int main() {
    std::string input;
    std::vector<int> outputs;
    std::getline(std::cin, input);
    int count = atoi(input.c_str());

    for(int i=0; i < count; i++) {
	int output = 0;
	std::getline(std::cin, input);
	istringstream iss(input);
	std::vector<std::string> tokens{istream_iterator<std::string>{iss},
                      						istream_iterator<std::string>{}};
	int snake_count = atoi(tokens[0].c_str());
	int query_count = atoi(tokens[1].c_str());
	
	int snakes[snake_count];
	int queries[query_count];
	int element_array[snake_count];

	std::getline(std::cin, input);
	istringstream instream(input);
	std::vector<std::string> elements{istream_iterator<std::string>{instream},
								     istream_iterator<std::string>{}};
	
	for(int j = 0; j < snake_count; j++) {
		element_array[j] = atoi(elements[j].c_str());
	}
	
	for(int j = 0; j < query_count; j++) {
		std::getline(std::cin, input);
		queries[query_count] = atoi(input.c_str());

		std::vector<int> sorted = abacus_sort(element_array, sizeof(element_array) / sizeof(int));

		for(int n = 0; n < snake_count; n++) {
			sorted[n] = sorted[n] + n;
			if(sorted[n] >= queries[j]) {
				output++;
			}
		}
		outputs.push_back(output);		
	}
    }
    for (int i = 0; i < outputs.size(); i++) {
     	std::cout << outputs[i] << "\n";
    }
}
