package EvolutionGamePackage;

public class EvolutionSimulator
{
    public EvolutionSimulator() throws InterruptedException
    {
        run();
    }
    public void run() throws InterruptedException
    {
        new EvolutionGamePanel();
    }

    public static void main(String[] args) throws InterruptedException
    {
        new EvolutionGamePanel();
    }
}
