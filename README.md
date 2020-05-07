# BlockChainSimulated
 simple simulated blockchain with proof of work, merkle tree and genesis block, subsequent block creation in Java
 I am building a sample blockchain using Java language that adds money transfer transactions between 4 users such as 
 Alice, Bob, Charlie and Dean. 
 The simulated PoW is also implemented between the same users who compete with each other to win the mining process. 
 
 Main method resides in chain.java
 Functionality covered :
1) add block definition
2) add genesis block
3) add transactions in to the block
4) add miners with certain CPU power. 
5) add block difficulty.
6) add merkle root to the block header 
7) print the final blockchain



*********sample blockchain ****************

Creating and Mining Genesis block... 

Genesis block added... 

Trying to Mine block 1... 

number of transactions is 3

Merkle Root : 34b15f096c089f0b14bb138c44bffb7aafca44e155ffc62de0a3a4e55f06a869

Selecting miners 

Alice is selected as miner

Block Mined!!! : 04d8495970ecbb549ff35d354e7cfe35c0fb625297c452d921785927855ff4e7


The block chain: 

[
  {
    "index": 0,
    "nonce": 0,
    "timeStamp": 1588826091145,
    "hash": "f1534392279bddbf9d43dde8701cb5be14b82f76ec6607bf8d6ad557f60f304e",
    "previousHash": "0",
    "NumberOfTrans": 0
  },
  {
    "index": 1,
    "nonce": 7,
    "timeStamp": 1588826091159,
    "hash": "04d8495970ecbb549ff35d354e7cfe35c0fb625297c452d921785927855ff4e7",
    "previousHash": "f1534392279bddbf9d43dde8701cb5be14b82f76ec6607bf8d6ad557f60f304e",
    "merkleRoot": "34b15f096c089f0b14bb138c44bffb7aafca44e155ffc62de0a3a4e55f06a869",
    "NumberOfTrans": 3,
    "transactions": [
      {
        "amount": "10",
        "From": "Alice",
        "To": "Bob"
      },
      {
        "amount": "20",
        "From": "Bill",
        "to": "Bob"
      },
      {
        "amount": "200",
        "From": "Bob",
        "to": "Bill"
      }
    ]
  }
]
