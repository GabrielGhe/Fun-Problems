"""
Method used to show the possible combinations
of pairs of parenthesis'

@param: {int} open_paren    [num of available open parenthesis]
@param: {int} close_paren   [num of available closing parenthesis]
@param: {int} balance_paren [balance of parenthesis]
@param: {int} list_paren    [list containing combination so far]
"""
def paren_helper(open_paren, close_paren, balance_paren, list_paren):
    
    #Base Case: if the open number of open and close brackets = 0
    if open_paren + close_paren == 0:
        print "".join(list_paren)
        return
    
    #Case 1: if balance > 0 and close brackets > 0
    if balance_paren > 0 and close_paren > 0:
        list_paren.append(")")
        paren_helper(open_paren, close_paren - 1, balance_paren - 1, list_paren)
        list_paren.pop()
        
    #Case 2: if there are still open brackets to be placed
    if open_paren > 0:
        list_paren.append("(")
        paren_helper(open_paren - 1, close_paren, balance_paren + 1, list_paren)
        list_paren.pop()

"""
Method used to determine all
the possible ways of opening and
closing a number of pairs of
parenthesis'

@param: {int} num [number of pairs of parenthesis] 
"""
def paren(num):
    print "Number of parenthesis = {0}".format(num)
    paren_helper(num, num, 0, [])
    print "---------------------"
    
paren(2)
paren(3)
