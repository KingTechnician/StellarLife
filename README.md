# StellarLife
A decision tree algorithm that analyzes the life cycle of a star based on known estimations.

This project was to help me grasp the concept of decision tree algorithms, and I will include details as to exactly how this one works.

The comparisons used to develop the tree algorithm is based on this image: https://upload.wikimedia.org/wikipedia/commons/4/47/Star_Life_Cycle_Chart.jpg

There are 3 primary objects that were created in order to implement this:

  -Comparison
  
  -Decision Tree
  
  -StellarCycle
  
# Comparison Object
The Comparison object is quite simple; they are the nodes that correspond to specific conditions, and when those conditions are true, and action will be implemented.

Properties:

  -condition: A boolean holding the condition corresponding to the node
  
  -action: A String representing the action or text that needs to be done if the condition is true
  
  -left, mid,right: Branches of the stree that will connect to other conditions.

There is only one constructor, that simply takes a boolean as a parameter, sets the boolean as the condition, and instantiates the Comparison object.

There is also a boolean to check if the left, mid, and right Comparisons are all empty (which would indicate the end of that branch of the tree)

# DecisionTree Object
The DecisionTree object is meant to hold the root of the tree. It can be compared to the typical LinkedList class, which is mainly meant to hold the head node of a linked list.

It has one constructor that simply sets the root node to a specified boolean.

# StellarCycle
The StellarCycle class is what will determine all of the decision-making, with DecisionTree and Comparison as its foundation. Each star will be applied to a certain StellarCycle.

Properties:
  -name: A string that simply holds the name of the specified star.
  
  -mass: The mass of the star with respect to the mass of the Sun. (Example: a star 8 times the mass of the Sun will have a mass of "8.0", and "0.5" if it is half the mass of the Sun.
  
  -loseHelium: Whether or not the star will lose helium at some point before it loses its structure (which will be determined by the user).
  
  -lifeCycle: String that will hold a description of the life cycle of the star, after proper analysis.
  
  -tree: DecisionTree that will hold the unique conditions necessary to perform analysis.
  
 The StellarCycle class has only one constructor, which accepts the mass, name, and whether or not the star will lose helium before it loses its structure, all input by the user. It will set those properties, then create the DecisionTree based on the conditions specified in the earlier pasted image at the beginning of this file.
 
 ## beginAnalysis method
 This method is a recursive method that will accept the root of the decision tree created in the constructor. It will run through the entire decision tree. The process is simple:
 
  -Check to see if the current condition is true.
  
    -If it is, add the action tied to the Comparison to the lifeCycle String. Check if the left, mid, or right nodes are true (Because of the nature of the choices, only one will ever be true)
    
    -If one of them is, call the beginAnalysis method for that node. If not, return.

Finally, there is a toString method that will print the name of the star, its mass, whether or not it has lost helium before losing its structure. It will also print the life cycle that has just been analyzed.
