#!/bin/bash

git fetch --all
git reset --hard origin/master

# note the SHA-1 of latest commit
#git checkout master
# reset your branch head to your previously detached commit
git reset --hard

git pull https://github.com/JonyCseDu/Energy-Simulator.git
git config --global push.default matching
git config --global push.default simple

