# java-alg-project

Author: Samuel Kent

Solutions for 4 different problems using appropriate algorithms implemented in Java. Additional analysis of each solution's worst case time complexity

Problem Specifications:
Cargo
It is important for a cargo ship crew to be able to predict what total mass of cargo they will have on board at points
throughout their voyage. You are tasked with writing a system to keep track of the mass of cargo on board at each
point along the route as new jobs come in to transport some cargo from one port to another.
Consider some planned route p[0], p[1], p[2], ... where each p[i] is a port visited along the route. We
would like to be able to perform a few different operations:
Add a job carrying some cargo from one port to another (receiving port can not be before sending port)
Remove a previously added job
Find what total mass of cargo we will have at some point along the route
We represent all three of these operations with the Query class provided in the Cargo interface:
cargoMass is the mass of cargo being transported (may be negative to delete a previous job)
collect is the index of the port at which we will collect the cargo
deliver is the index of the port to which the cargo must be delivered ( collect <= deliver )
The result of a query is the total mass of cargo expected to be on board when leaving p[collect] (after any
change caused by the query). The effects of each query are persistent and will impact the results of later queries.
For example:
{cargoMass = 4, collect = 2, deliver = 5} represents adding a job carrying 4 mass units of cargo from
p[2] to p[5]
{cargoMass = -4, collect = 2, deliver = 5} represents deleting the above job
{cargoMass = 0, collect = 3, deliver = 3} represents a query to find the total mass of cargo that will be
on board when departing from p[3]
Implement a function int[] departureMasses(int stops, Query[] queries) , where stops is the number of
stops on the route and queries is a sequence of queries. The function should perform the query operations in the
order given, and return an array of the result of each query in the same order.
You may assume 0 < stops <= 10^6 , 0 < queries.length <= 10^6 , collect <= deliver , and no total cargo
mass at any point will overflow an int .
Where N is the number of stops and Q is the number of queries, a solution with a computational complexity of
O(N Q) is not expected to pass the large test cases, but most faster algorithms should.
Example
Consider departureMasses(8, queries) , with queries of the form {cargoMass, collect, deliver} as follow:
Total cargo mass when leaving each port is initially {0, 0, 0, 0, 0, 0, 0, 0}
{4, 2, 5} gives {0, 0, 4, 4, 4, 0, 0, 0} , result is 4
{3, 3, 8} gives {0, 0, 4, 7, 7, 3, 3, 3} , result is 7
{0, 4, 4} gives {0, 0, 4, 7, 7, 3, 3, 3} , result is 7
{-4, 2, 5} gives {0, 0, 0, 3, 3, 3, 3, 3} , result is 0
Therefore departureMasses would return the array {4, 7, 7, 0} 
