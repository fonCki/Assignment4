
# Assignment 4, SDJ2 


You must design and implement the Kingdom simulation shown below. The ultimate goal is to get valuables, so the king can throw parties.

The King has a Treasure room (lower left corner) with the door guarded buy a Guardsman. The valuables in the Treasure room comes from a Mine (upper right corner) with Miners transporting their findings to a Deposit (lower right corner). Occasionally, Valuable Transporters are moving valuables from Deposit to the Treasure room and Accountants are counting all valuables in the Treasure room. When the King feels like partying, he takes valuables from the Treasure room if there are enough for a party.



![App Screenshot](https://github.com/fonCki/Assignment4/blob/988036134aca96fdeed82e972b2da3aebd8e783d/Extra/Kingdom.png)




## Requirements

- Threads to simulate the actors: King, Accountant, ValuableTransporter and ValuablesMiner.
- Singleton to log any action, e.g. when an actor waits or perform a job.
- A class to create valuables, e.g. Diamond, GoldNugget, Jewel, Ruby, WoodenCoin, etc, for the Miner.
- JUnit testing an ArrayList to be used in the Deposit. 
- Adapter for the ArrayList in the Deposit. The Deposit is a blocking queue, you should use the provided ArrayList as the basis for this blocking queue.
- Producer-Consumer for the Deposit with the Miners and Valuables Transporters being producers and consumers, respectively. I.e. Miners insert valuables into the Deposit, and Valuable Transporters take them out.
- Readers-Writers for the Treasure room and Guardsman.
- Proxy between the Treasure room and the Guardsman.

## Authors

- [Alfonso Ridao](https://alfonso.ridao.ar)
- For support, email alfonso@ridao.ar.

