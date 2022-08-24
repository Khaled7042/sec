package org.demo;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {
    public static void main(String[] args) {
        List<Block<Transaction>> blockChainList =  new ArrayList<>();


        Transaction transaction = new Transaction(1,234.67F,"John","Mila");
        Block<Transaction> genesis = new Block<>(transaction, 0);
        blockChainList.add(genesis);

        transaction = new Transaction(1,32234.67F,"John","Mila");
        Block<Transaction> helloBlock = new Block<>(transaction, blockChainList.get(blockChainList.size()-1).getHash());
        blockChainList.add(helloBlock);

        transaction = new Transaction(1,232434.67F,"John","Mila");
        Block<Transaction> worldBlock = new Block<>(transaction, blockChainList.get(blockChainList.size()-1).getHash());
        blockChainList.add(worldBlock);

        transaction = new Transaction(1,233244.67F,"John","Mila");
        Block<Transaction> dZoneBlock = new Block<>(transaction, blockChainList.get(blockChainList.size()-1).getHash());
        blockChainList.add(dZoneBlock);

        System.out.println("---------------------");
        System.out.println("- BlockChain -");
        System.out.println("---------------------");
        blockChainList.forEach(System.out::println);
        System.out.println("---------------------");
        System.out.println("Is valid?: " + validate(blockChainList));
        System.out.println("---------------------");

        // corrupt block chain by modifying one of the block
        transaction = new Transaction(1,2244.67F,"John","Mila");
        Block<Transaction> hiBlock = new Block<>(transaction, blockChainList.get(blockChainList.size()-1).getHash());
        int index = blockChainList.indexOf(helloBlock);
        blockChainList.remove(index);
        blockChainList.add(index, hiBlock);
        System.out.println("Corrupted block chain by replacing 'Hello' block with 'Hi' Block");

        System.out.println("---------------------");
        System.out.println("- BlockChain -");
        System.out.println("---------------------");
        blockChainList.forEach(System.out::println);
        System.out.println("---------------------");
        System.out.println("Is valid?: " + validate(blockChainList));
        System.out.println("---------------------");


    }


    private static boolean validate(List<Block<Transaction>> blockChain) {
        boolean result = true;

        Block lastBlock = null;
        for(int i = blockChain.size() -1; i >= 0; i--) {
            if(lastBlock == null) {
                lastBlock = blockChain.get(i);
            }
            else {
                Block current = blockChain.get(i);
                if(lastBlock.getPreviousHash() != current.getHash()) {
                    result = false;
                    break;
                }
                lastBlock = current;
            }
        }

        return result;
    }
}