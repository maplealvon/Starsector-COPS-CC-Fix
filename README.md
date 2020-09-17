# Starsector-COPS-CC-Fix
Fixes COPS commissioned crew to work in both commissioned and allied states.  
Removes Rhodan as the ship causes CTD in combat.  
Compatible with COPS v2.0b, Starsector v0.9.1a.

## Install
Install COPS and then extract fix files into COPS mod folder.

## How it works
Original COPS CC checks for commissioned status and self-removes if not commissioned, so it only works under COPS commission and not alliance.  
Fix adds a CC hullmod that provides the same stats but does not self-remove. Instead, it checks for COPS commission and removes the original CC hullmod.

Rhodan causes CTD in combat, fix disables Rhodan by removing it from ship_data.csv, COPS.faction, and default_ship_roles.txt.
