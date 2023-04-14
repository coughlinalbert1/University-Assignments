'''
author Albert Coughlin
version Python 3.9.6

prompt:
Write a program in Python, only using Python's functional programming elements, that performs the following computation:

Given a list of triangles, represented by the lengths of their 3 sides generate a list with only the equilateral
triangles. Then for the list of equilateral triangles, generate a list of the areas of the given those triangles.
'''
import math

# list of triangle side lengths in meters
triangles = [[2, 0.5, 1.0], [4, 3, 6], [4, 4, 4], [5, 5, 5], [9, 9, 9]]
#triangles = []
#triangles = [[2, 0.5, 1.0], [4, 3, 6], [3, 4, 5]]

def main(list):
    '''
    :param list: the triangles that need to be checked for side equality
    :return: a list of the areas
    '''
    if len(list) > 0:
        # iterates through the list and filter out the lists that do not meet the condition
        equilateralList = [i[0] for i in list if(i[0] == i[1] == i[2])]

        if(len(equilateralList) > 0):
            # iterates through the list and applies the area function
            areas = ["{:.2f}".format((math.sqrt(3)/4 * (math.pow(s, 2)))) for s in equilateralList]

            # loop both lists to print out the side lengths and their respective areas
            for side, area in zip(equilateralList, areas):
                print(f'Sides: {side} m x {side} m x {side} m \t Area: {area} m^2\n')
        # No equilateral triangles
        else:
            print("There are no equilateral triangles in the list")
            return []
        return areas
    # Empty list
    else:
        print("There are no triangles in the list")
        return []

print(main(triangles))