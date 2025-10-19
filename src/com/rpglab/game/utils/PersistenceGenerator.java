package com.rpglab.game.utils;

import java.io.File;

import com.rpglab.game.game.CombatScene;
import com.rpglab.game.game.Battle;
import com.rpglab.game.characters.Monster;
import com.rpglab.game.items.Weapon;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

/**
 * Utility class responsible for saving and loading a CombatScene ("Batalha").
 * Uses JAXB (Jakarta XML Binding) to marshal/unmarshal objects to XML.
 */
public class PersistenceGenerator {

    /**
     * Saves the given CombatScene to an XML file inside a 'saves' directory.
     * @param b the CombatScene to save
     * @param nomeBatalha file name (without extension) to use for the saved file
     */
    public static void saveBattle(CombatScene b, String battleName) {
        try {
            File dir = new File("saves");
            if (!dir.exists()) dir.mkdirs();

            File out = new File(dir, battleName + ".xml");

            JAXBContext ctx = JAXBContext.newInstance(CombatScene.class, Monster.class, Weapon.class);
            Marshaller m = ctx.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(b, out);

            System.out.println("Batalha salva em: " + out.getAbsolutePath());
        } catch (JAXBException e) {
            System.err.println("Erro ao salvar batalha: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Loads a CombatScene from the saves directory using the provided name.
     * @param nomeBatalha the file name (without extension) used when saving
     * @return the loaded CombatScene, or null if an error occurs
     */
    public static CombatScene loadBattle(String nomeBatalha) {
        try {
            File in = new File("saves", nomeBatalha + ".xml");
            if (!in.exists()) {
                System.err.println("Arquivo de batalha não encontrado: " + in.getAbsolutePath());
                return null;
            }

            JAXBContext ctx = JAXBContext.newInstance(CombatScene.class, Monster.class, Weapon.class);
            Unmarshaller u = ctx.createUnmarshaller();
            Object obj = u.unmarshal(in);
            if (obj instanceof CombatScene) {
                return (CombatScene) obj;
            } else {
                System.err.println("Arquivo XML não contém um CombatScene válido.");
                return null;
            }
        } catch (JAXBException e) {
            System.err.println("Erro ao carregar batalha: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Save a full game session (Batalha) to XML.
     */
    public static void saveGame(Battle b, String name) {
        try {
            File dir = new File("saves");
            if (!dir.exists()) dir.mkdirs();

            File out = new File(dir, name + ".xml");

            JAXBContext ctx = JAXBContext.newInstance(Battle.class, CombatScene.class, com.rpglab.game.characters.Monster.class, com.rpglab.game.items.Weapon.class);
            Marshaller mar = ctx.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(b, out);

            System.out.println("Jogo salvo em: " + out.getAbsolutePath());
        } catch (JAXBException e) {
            System.err.println("Erro ao salvar jogo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Load a full game session (Batalha) from XML.
     */
    public static Battle loadGame(String name) {
        try {
            File in = new File("saves", name + ".xml");
            if (!in.exists()) {
                System.err.println("Arquivo de jogo não encontrado: " + in.getAbsolutePath());
                return null;
            }

            JAXBContext ctx = JAXBContext.newInstance(Battle.class, CombatScene.class, com.rpglab.game.characters.Monster.class, com.rpglab.game.items.Weapon.class);
            Unmarshaller u = ctx.createUnmarshaller();
            Object obj = u.unmarshal(in);
            if (obj instanceof Battle) {
                Battle loaded = (Battle) obj;
                
                // Restore hero actions after deserialization
                if (loaded.getHero() != null) {
                    loaded.getHero().initActions();
                }
                
                // Restore monster actions (TODO: implement Monster.initActions() if needed)
                if (loaded.getScenes() != null) {
                    for (CombatScene scene : loaded.getScenes()) {
                        if (scene == null || scene.getMonsters() == null) continue;
                        // for (com.rpglab.game.characters.Monster m : scene.getMonsters()) {
                        //     try { m.initActions(); } catch (Exception ex) { /* ignore */ }
                        // }
                    }
                }
                return loaded;
            } else {
                System.err.println("Arquivo XML não contém um Battle válido.");
                return null;
            }
        } catch (JAXBException e) {
            System.err.println("Erro ao carregar jogo: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
