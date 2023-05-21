package Package;

import java.util.*;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;


public class EvolutionGamePanel extends JFrame implements Runnable
{
    public JPanel gridPanel;
    Thread gameThread;
    Random random = new Random();

    public EvolutionGamePanel() throws InterruptedException 
    {
        // Set up the JFrame
        setTitle("Evolution Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    
        // Create the JPanel with a GridLayout manager
        gridPanel = new JPanel(new GridLayout(18, 18));
    
        // Add squares to the grid
        for (int i = 0; i < 18 * 18; i++) 
        {
            JPanel squarePanel = new JPanel();
            squarePanel.setPreferredSize(new Dimension(50, 50));
            squarePanel.setBackground(Color.WHITE);
            squarePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            gridPanel.add(squarePanel);
        }
    
        // Add the gridPanel to the JFrame
        add(gridPanel);
    
        // Pack the JFrame and make it visible
        pack();
        setVisible(true);

        makeElements();

        deployAnimal(5);
        deployAnimal(100);
        for(int i = 200; i < 217; i++)
        {
            if(i % 2 == 0)
            {
                deployAnimal(i);
            }
            
        }

        gameThread = new Thread(this);
        gameThread.start();

        moveAnimals();
    }
    
    public void makeElements()
    {

        setDiagonalToptoBottom(0, 13, 0);
        setDiagonalToptoBottom(18, 12, 0);
        setDiagonalToptoBottom(36, 11, 0);
        setRectangle(245, 7, 5, 0);

        initializeGrass();
        makeTrees();
        makePlants();
    }
    public void initializeGrass()
    {
        for(int i = 0; i < 324; i++)
        {
            JPanel squarePanel = (JPanel) gridPanel.getComponent(i);
            if(squarePanel.getBackground().equals(Color.BLUE) == false) {
                Nature n = new Nature(4);
                squarePanel.add(n);
                squarePanel.setBackground(n.getColor()); 
                n.setVisible(false);
            }
        }
    }
    public void setDiagonalToptoBottom(int index, int numDiagonals, int id)
    {
        for(int i = 1; i <= numDiagonals; i++)
        {
            if(index < 324)
            {
                JPanel squarePanel = (JPanel) gridPanel.getComponent(index);
                Nature n = new Nature(id);
                squarePanel.add(n);
                squarePanel.setBackground(n.getColor()); 
                n.setVisible(false);

                index += 19;
            }
        }
    }
    public void setRectangle(int index, int length, int height, int id)
    {
        int i = 0;
        int outerLoop = 0;
        while(outerLoop < height)
        {
            while(i < length)
            {

                JPanel squarePanel = (JPanel) gridPanel.getComponent(index+i);
                Nature n = new Nature(id);
                squarePanel.add(n);
                squarePanel.setBackground(n.getColor()); 
                n.setVisible(false);

                i++;
            }
            i = 0;
            index += 18;
            outerLoop++;
        }

    }
    public JLabel resizeImage(String path, int desiredWidth, int desiredHeight)
    {
	    ImageIcon originalIcon = new ImageIcon(path);
	    Image originalImage = originalIcon.getImage();

	    Image resizedImage = originalImage.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);

	    // Create a new ImageIcon from the resized image
	    ImageIcon resizedIcon = new ImageIcon(resizedImage);

	    // Create a JLabel to hold the resized image
	    JLabel imageLabel = new JLabel(resizedIcon);

	    return imageLabel;
    }
    public void makeTrees()
    {
        for (int i = 0; i < 324; i++) 
        {
            JPanel squarePanel = (JPanel) gridPanel.getComponent(i);
            
            Component[] componentList = squarePanel.getComponents();
            for(Component c : componentList){
            //Find the components you want to remove
            if(c instanceof Nature)
            {
                if( ((Nature) c).getID() == 4)
                {
                    Color color = new Color(136, 213, 107);
                    if(squarePanel.getBackground().equals(color))
                    {
                        if( ((int) (Math.random() * 11 + 1)) == 5)
                        {
                            //Remove it
                            squarePanel.remove(c);

                            String path = "C:\\Users\\Jayan Sirikonda\\Downloads\\tree.png";

                            //Add the JLabel
                            JLabel imageLabel = resizeImage(path, 50, 30);

                            //Add the Tree Component
                            Nature n = new Nature(1);
                            n.add(imageLabel);
                            
                            squarePanel.add(n);
                            squarePanel.setBackground(n.getColor()); 
                            n.setVisible(true);
                        } 
                    }
                } 
            }
            //IMPORTANT
            squarePanel.revalidate();
            squarePanel.repaint();
        }


    }
}
    public void makePlants() 
    {
        int plantCount = 0;
        for (int i = 0; i < 324; i++) 
        {
            JPanel squarePanel = (JPanel) gridPanel.getComponent(i);
            Component[] componentList = squarePanel.getComponents();
            for(Component c : componentList){
                //Find the components you want to remove
                if(c instanceof Nature)
                {
                    if( ((Nature) c).getID() == 4)
                    {
                        Color color = new Color(136, 213, 107);
                        if(squarePanel.getBackground().equals(color) && plantCount < 2)
                        {
                            if( ((int) (Math.random() * 11 + 1)) == 5)
                            {
                                //Remove it
                                squarePanel.remove(c);

                                //Add the Plant Component    
                                Nature n = new Nature(2);
                                squarePanel.add(n);
                                squarePanel.setBackground(n.getColor()); 
                                n.setVisible(true);

                                plantCount++;
                            } 
                        }
                    } 
                }
                //IMPORTANT
                squarePanel.revalidate();
                squarePanel.repaint();
            }
        }
    }

    public void deployAnimal(int index)
    {
        JPanel squarePanel = (JPanel) gridPanel.getComponent(index);

        Rabbit r1 = new Rabbit("Small Rabbit AAA");
        r1.setBackground(r1.getColor());
        squarePanel.add(r1);
        r1.setVisible(true);

        //IMPORTANT
        squarePanel.revalidate();
        squarePanel.repaint();
    }

    public void swapNatureComponents(int index1, int index2) throws InterruptedException
    {
        JPanel squarePanel1 = (JPanel) gridPanel.getComponent(index1);
        JPanel squarePanel2 = (JPanel) gridPanel.getComponent(index2);

        Component[] componentList1 = squarePanel1.getComponents();
        for(Component c1 : componentList1)
        {
            if(c1 instanceof Animal)
            {
                Animal animalObject = (Animal)c1;

                TimeUnit.SECONDS.sleep(1);

                squarePanel2.add(animalObject);

                squarePanel1.remove(c1);
                
            }
        }

        squarePanel1.revalidate();
        squarePanel1.repaint();

        squarePanel2.revalidate();
        squarePanel2.repaint();

    }

    public void printComponents()
    {
        for(int i = 0; i < 324; i++)
        {
            JPanel squarePanel = (JPanel) gridPanel.getComponent(i);
            int componentCount = squarePanel.getComponentCount();
            System.out.println(componentCount + " i: " + i);
        }
    }
    
    public void run() {
        long lastTime = System.nanoTime(); //Research
        double amountOfTicks = 100.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        while(true)
        {
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            if(delta >= 1)
            {
                repaint();
                delta--;
                //System.out.println("TEST");
            }
        }
    }

    private void moveAnimals() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < gridPanel.getComponentCount(); i++) {
                    JPanel squarePanel = (JPanel) gridPanel.getComponent(i);
                    Component[] components = squarePanel.getComponents();
    
                    // Find the Animal object in the squarePanel
                    Animal animal = null;
                    for (Component component : components) {
                        if (component instanceof Animal) {
                            animal = (Animal) component;
                            break;
                        }
                    }
    
                    // Move the Animal object to a neighboring squarePanel if found
                    if (animal != null) {
                        int currentIndex = i;
                        int nextIndex = getNextPanelIndex(currentIndex);
    
                        if (nextIndex != -1) {
                            JPanel nextPanel = (JPanel) gridPanel.getComponent(nextIndex);
                            Component[] nextComponents = nextPanel.getComponents();
    
                            boolean hasAnimal = false;
                            for (Component nextComponent : nextComponents) {
                                if (nextComponent instanceof Animal) {
                                    hasAnimal = true;
                                    break;
                                }
                            }

                            boolean isWaterOrTree = false;
                            for(Component nextComponent: nextComponents)
                            {
                                if(nextComponent instanceof Nature)
                                {
                                    if( ((Nature)nextComponent).getID() == 0 || ((Nature)nextComponent).getID() == 1)
                                    {
                                        isWaterOrTree = true;
                                    }
                                }
                            }
    
                            // Move the Animal object to the nextPanel if it does not contain another Animal object
                            if (!hasAnimal && (isWaterOrTree == false)) {
                                try {
                                    swapNatureComponents(currentIndex, nextIndex);
                                } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                                gridPanel.repaint(); // Refresh the grid after the movement
                            }
                        }
                    }
                }
            }
        }, 0, 1000); // Set the desired delay between each movement in milliseconds
    }
    
    
    private int getNextPanelIndex(int currentIndex) {
        List<Integer> neighborIndices = getNeighborIndices(currentIndex);
        if (!neighborIndices.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(neighborIndices.size());
            return neighborIndices.get(randomIndex);
        }
        return -1; // No valid neighbor found
    }
    
    //Returns all possible indices that an animal object can move to
    public List<Integer> getNeighborIndices(int index) {
        List<Integer> neighbourIndices = new ArrayList<>();
    
        int row = index / 18;
        int col = index % 18;
    
        int[] rowOffsets = { -1, 1, 0, 0, -1, -1, 1, 1 };
        int[] colOffsets = { 0, 0, -1, 1, -1, 1, -1, 1 };
    
        for (int i = 0; i < 8; i++) {
            int newRow = row + rowOffsets[i];
            int newCol = col + colOffsets[i];
    
            if (newRow >= 0 && newRow < 18 && newCol >= 0 && newCol < 18) {
                int newIndex = newRow * 18 + newCol;
                neighbourIndices.add(newIndex);
            }
        }
    
        return neighbourIndices;
    }
}
