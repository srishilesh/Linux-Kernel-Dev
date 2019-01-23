#!/bin/bash
print()
{
echo Hello $1
}
print shilesh
print jagat
command ps
ls()
{
command ls -lh
}

ls

print_something () {

echo Hello $1

return 5

}


print_something Mars

print_something Jupiter

echo The previous function has a return value of $?
