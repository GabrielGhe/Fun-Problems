def move(n, fr, to, via):
  if n == 1:
    print "Moving pole {0} to {1}".format(fr, to)
  else:
    move(n - 1, fr, via, to)
    move(1, fr, to, via)
    move(n - 1, via, to, fr)
    
move(2, 1, 3, 2)
