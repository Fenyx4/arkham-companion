package main

import (
    "encoding/json"
    "fmt"
    "io/ioutil"
    "log"
    "os"
	"strings"
)

type JsonFormat struct {
	Expansions []JsonExpansion `json:"expansions"`
}

type JsonExpansion struct {
	ID					int    `json:"id"`
	Name				string `json:"name"`
	IconPath			string `json:"iconPath"`
	CbIconPathOff		string `json:"cbIconPathOff"`
	CbIconPathOn		string `json:"cbIconPathOn"`
	Neighborhoods 		[]JsonNeighborhood `json:"neighborhoods,omitempty"`
	OtherWorldLocations []JsonLocation `json:"otherWorldLocations,omitempty"`
	Colors 				[]JsonColor `json:"colors,omitempty"`
}

type JsonNeighborhood struct {
	Name        string `json:"name"`
	ButtonPath 	string `json:"buttonPath"`
	CardPath   	string `json:"cardPath"`
	Cards 		[]JsonCard `json:"cards,omitempty"`
	Locations 		[]JsonLocation `json:"locations,omitempty"`
}

type JsonCard struct {
	Encounters []JsonEncounter `json:"encounters,omitempty"`
	ExpansionIds []int `json:"expansionIds,omitempty"`
	ColorIds []int    `json:"colorID"`
}

type JsonEncounter struct {
	Text string `json:"text"`
	LocationId int    `json:"locationId"`
}

type JsonLocation struct {
	LocationId int    `json:"locationId"`
	Name        string `json:"name"`
	//LocButtonPath string `json:"locButtonPath"`
	Sort int    `json:"sort"`
	ColorIds []int    `json:"colorID"`
}

type JsonColor struct {
	ColorID int    `json:"colorID"`
	Name string `json:"name"`
	Cards 		[]JsonCard `json:"cards,omitempty"`
	ColorButtonPath string `json:"colorButtonPath"`
	ColorPipOnPath string `json:"colorPipOnPath,omitempty"`
	ColorPipOffPath string `json:"colorPipOffPath,omitempty"`
}



type Expansion struct {
	ExpID         int    `json:"expID"`
	ExpIconPath   string `json:"expIconPath"`
	ExpName	   	  string `json:"expName"`
}

type Card struct {
	CardID       int    `json:"cardID"`
	NeighborID  int    `json:"neiID"`
}

type CardToExpansion struct {
	CardID       int    `json:"cardID"`
	ExpansionID int    `json:"expID"`
}

type Neighborhood struct {
	ButtonPath string `json:"ButtonPath"`
	CardPath   string `json:"CardPath"`
	ExpansionID int    `json:"ExpansionID"`
	Name        string `json:"Name"`
	NeighborhoodID int    `json:"NeighborhoodID"`
}

type Location struct {
	LocButtonPath string `json:"locButtonPath"`
	LocExpID      int    `json:"locExpID"`
	LocID         int    `json:"locID"`
	LocName       string `json:"locName"`
	NeiID         int    `json:"neiID"`
	Sort          int    `json:"sort"`
}

type Color struct {
	ColorButtonPath string `json:"colorButtonPath"`
	ColorExpID      int    `json:"colorExpID"`
	ColorID         int    `json:"colorID"`
	ColorName       string `json:"colorName"`
	ColorPipOnPath  string `json:"colorPipOnPath,omitempty"`
	ColorPipOffPath string `json:"colorPipOffPath,omitempty"`
}

type LocationToColor struct {
	LocID    int `json:"locID"`
	ColorID  int `json:"colorID"`
}

type CardToEncounter struct {
	EncID    int `json:"encID"`
	CardID   int `json:"cardID"`
}

type Encounters struct {
	EncID	int    `json:"encID"`
	EncText string `json:"encText"`
	LocID	int    `json:"locID"`
}

type CardToColor struct {
	CardID int `json:"cardToColorCardID"`
	ColorID int `json:"cardToColorColorID"`
}

func readAndMarshalJson(filePath string, v interface{}) error {
	file, err := os.Open(filePath)
	if err != nil {
		return err
	}
	defer file.Close()

	bytes, err := ioutil.ReadAll(file)
	if err != nil {
		return err
	}

	if err := json.Unmarshal(bytes, v); err != nil {
		return err
	}

	return nil
}

func main() {
    // Read Expansion.json file
	var expansions []Expansion
	err := readAndMarshalJson("Expansion.json", &expansions)
	if err != nil {
		log.Fatal(err)
	}
    // Print the data
    fmt.Printf("%+v\n", expansions)

	// Read Card.json file
	var cards []Card
	err = readAndMarshalJson("Card.json", &cards)
	if err != nil {
		log.Fatal(err)
	}

	// Read CardToExpansion.json file
	var cardToExp []CardToExpansion
	err = readAndMarshalJson("CardToExpansion.json", &cardToExp)
	if err != nil {
		log.Fatal(err)
	}

	// Read Neighborhood.json file
	var neighborhoods []Neighborhood
	err = readAndMarshalJson("Neighborhood.json", &neighborhoods)
	if err != nil {
		log.Fatal(err)
	}

	// Read Location.json file
	var locations []Location
	err = readAndMarshalJson("Location.json", &locations)
	if err != nil {
		log.Fatal(err)
	}

	// Read Color.json file
	var colors []Color
	err = readAndMarshalJson("Color.json", &colors)
	if err != nil {
		log.Fatal(err)
	}

	// Read LocationToColor.json file
	var locationToColors []LocationToColor
	err = readAndMarshalJson("LocationToColor.json", &locationToColors)
	if err != nil {
		log.Fatal(err)
	}

	var cardToEncounters []CardToEncounter
	err = readAndMarshalJson("CardToEncounter.json", &cardToEncounters)
	if err != nil {
		log.Fatal(err)
	}

	var encounters []Encounters
	err = readAndMarshalJson("Encounter.json", &encounters)
	if err != nil {
		log.Fatal(err)
	}

	var cardToColor []CardToColor
	err = readAndMarshalJson("CardToColor.json", &cardToColor)
	if err != nil {
		log.Fatal(err)
	}
	
	writeJsonFormat(expansions, cards, neighborhoods, cardToExp, locations, colors, locationToColors, cardToEncounters, encounters, cardToColor, "expansions.json")
}

func writeJsonFormat(expansions []Expansion, cards []Card, neighborhoods []Neighborhood, cardToExp []CardToExpansion, locations []Location, colors []Color, locationToColors []LocationToColor, cardToEncounters []CardToEncounter, encounters []Encounters, cardToColor []CardToColor, outputFile string) {
	jsonFormat := JsonFormat{
		Expansions: make([]JsonExpansion, len(expansions)),
	}

	// Load expansions
	expansionsMap := make(map[int]*JsonExpansion)
	for i, exp := range expansions {
		var expansionShortName string
		if exp.ExpIconPath == "" {
			expansionShortName = "ba" // Default for base expansion
		} else {
			// Extract the short name from the icon path
			end := strings.Index(exp.ExpIconPath, ".png")
			start := strings.LastIndex(exp.ExpIconPath, "_") + 1
			expansionShortName = exp.ExpIconPath[start:end]
		}

		jsonFormat.Expansions[i] = JsonExpansion{
			Name:         exp.ExpName,
			IconPath:     exp.ExpIconPath,
			CbIconPathOff: fmt.Sprintf("checkbox/btn_%s_check_off.png", expansionShortName),
			CbIconPathOn:  fmt.Sprintf("checkbox/btn_%s_check_on.png", expansionShortName),
		}
		expansionsMap[exp.ExpID] = &jsonFormat.Expansions[i]
	}

	
	encountersMap := make(map[int]*JsonEncounter)
	for _, enc := range encounters {
		jsonEncounter := JsonEncounter{
			Text: enc.EncText,
			LocationId: enc.LocID,
		}
		// Add the encounter to the map
		encountersMap[enc.EncID] = &jsonEncounter
	}

	cardIDToEncounterID := make(map[int][]int)
	for _, cte := range cardToEncounters {
		// Associate encounters with cards
		cardIDToEncounterID[cte.CardID] = append(cardIDToEncounterID[cte.CardID], cte.EncID)
	}

	cardIDToExpansionID := make(map[int][]int)
	for _, cte := range cardToExp {
		// Associate cards with expansions
		cardIDToExpansionID[cte.CardID] = append(cardIDToExpansionID[cte.CardID], cte.ExpansionID)
	}

	neighborhoodToCardsMap := make(map[int][]*JsonCard)
	cardsMap := make(map[int]*JsonCard)
	for _, card := range cards {
		// Initialize the card in the JSON format
		jsonCard := JsonCard{
			ColorIds: []int{},
			ExpansionIds: []int{},
		}

		// Add encounters to the card
		if encounterIDs, exists := cardIDToEncounterID[card.CardID]; exists {
			for _, encID := range encounterIDs {
				if encounter, exists := encountersMap[encID]; exists {
					jsonCard.Encounters = append(jsonCard.Encounters, *encounter)
				} else {
					log.Printf("Warning: Encounter ID %d not found for card %d", encID, card.CardID)
				}
			}
		} else {
			log.Printf("Warning: No encounters found for card ID %d", card.CardID)
		}

		// Add expansion IDs to the card
		if expansionIDs, exists := cardIDToExpansionID[card.CardID]; exists {
			for _, expID := range expansionIDs {
				if _, exists := expansionsMap[expID]; exists {
					jsonCard.ExpansionIds = append(jsonCard.ExpansionIds, expID)
				} else {
					log.Printf("Warning: Expansion ID %d not found for card %d", expID, card.CardID)
				}
			}
		} else {
			log.Printf("Warning: No expansions found for card ID %d", card.CardID)
		}

		neighborhoodToCardsMap[card.NeighborID] = append(neighborhoodToCardsMap[card.NeighborID], &jsonCard)
		cardsMap[card.CardID] = &jsonCard
	}

	colorToCardsMap := make(map[int][]*JsonCard)
	// Add cards to colors based on CardToColor
	for _, ctc := range cardToColor {
		if card, exists := cardsMap[ctc.CardID]; exists {
			// Add the card to the color's card list
			colorToCardsMap[ctc.ColorID] = append(colorToCardsMap[ctc.ColorID], card)
			log.Printf("Card %d added to color %d", ctc.CardID, ctc.ColorID)
		} else {
			log.Printf("Warning: Card ID %d not found for color ID %d", ctc.CardID, ctc.ColorID)
		}
	}

	// Load Neighborhoods and associate them with expansions
	neighborhoodsMap := make(map[int]*JsonNeighborhood)
	for _, nei := range neighborhoods {
		// Initialize the neighborhood in the JSON format
		jsonNeighborhood := JsonNeighborhood{
			Name:        nei.Name,
			ButtonPath:  nei.ButtonPath,
			CardPath:    nei.CardPath,
			Cards:     []JsonCard{},
		}

		// Add cards to the neighborhood
		if cards, exists := neighborhoodToCardsMap[nei.NeighborhoodID]; exists {
			for _, card := range cards {
				// Add the card to the neighborhood
				jsonNeighborhood.Cards = append(jsonNeighborhood.Cards, *card)
				log.Printf("Card added to neighborhood %s", nei.Name)
			}			
		} else {
			log.Printf("Warning: No cards found for neighborhood ID %d", nei.NeighborhoodID)
		}

		// Find the corresponding expansion for this neighborhood
		if exp, exists := expansionsMap[nei.ExpansionID]; exists {
			// Add the neighborhood to the expansion
			exp.Neighborhoods = append(exp.Neighborhoods, jsonNeighborhood)
			log.Printf("Neighborhoods: %d", exp.Name)
			log.Printf("Neighborhoods: %d", exp.Neighborhoods)
		} else {
			log.Printf("Warning: Expansion ID %d not found for neighborhood %s", nei.ExpansionID, nei.Name)
		}
		
		neighborhoodsMap[nei.NeighborhoodID] = &jsonNeighborhood
	}

	log.Printf("Neighborhoods: %d", jsonFormat.Expansions[0].Neighborhoods)
	log.Printf("Neighborhoods: %d", expansionsMap[1].Neighborhoods)

	// Add color IDs to locations based on LocationToColor
	locationToColorsMap := make(map[int][]int)
	for _, locColor := range locationToColors {
		log.Printf("LocationToColor: LocID %d, ColorID %d", locColor.LocID, locColor.ColorID)
		locationToColorsMap[locColor.LocID] = append(locationToColorsMap[locColor.LocID], locColor.ColorID)
	}

	// Load locations and associate them with neighborhoods (for arkham cards) or expansions (for otherworld locations)
	locationsMap := make(map[int]*JsonLocation)
	for _, loc := range locations {
		// Initialize the location in the JSON format
		jsonLocation := JsonLocation{
			//LocButtonPath: loc.LocButtonPath,
			LocationId:    loc.LocID,
			Name:       loc.LocName,
			Sort:          loc.Sort,
			ColorIds:      []int{}, // Initialize empty slice for color IDs
		}

		// Add color IDs to the location from the locationToColorsMap
		if colorIds, exists := locationToColorsMap[loc.LocID]; exists {
			log.Printf("Location %s has colors %v", loc.LocName, colorIds)
			jsonLocation.ColorIds = append(jsonLocation.ColorIds, colorIds...)
		} 

		// Find the corresponding neighborhood for this location
		if loc.NeiID != 0 {
			if nei, exists := neighborhoodsMap[loc.NeiID]; exists {
				// Add the location to the neighborhood
				nei.Locations = append(nei.Locations, jsonLocation)
			} else {
				log.Printf("Warning: Neighborhood ID %d not found for location %s", loc.NeiID, loc.LocName)
			}
		} else {
			// If no neighborhood, add to the expansion directly as on otherworld
			if exp, exists := expansionsMap[loc.LocExpID]; exists {
				// Add the location to the expansion
				exp.OtherWorldLocations = append(exp.OtherWorldLocations, jsonLocation)
			} else {
				log.Printf("Warning: Expansion ID %d not found for location %s", loc.LocExpID, loc.LocName)
			}
		}

		locationsMap[loc.LocID] = &jsonLocation
	}

	// Add colors to the JSON format
	colorsMap := make(map[int]*JsonColor)
	for _, color := range colors {
		jsonColor := JsonColor{
			ColorID:        color.ColorID,
			Name:           color.ColorName,
			ColorButtonPath: color.ColorButtonPath,
			ColorPipOnPath:  color.ColorPipOnPath,
			ColorPipOffPath: color.ColorPipOffPath,
		}

		// Add cards to the color
		if cards, exists := colorToCardsMap[color.ColorID]; exists {
			for _, card := range cards {
				// Add the card to the color
				jsonColor.Cards = append(jsonColor.Cards, *card)
			}
		} else {
			log.Printf("Warning: No cards found for color ID %d", color.ColorID)
		}

		// Add color to thier corresponding expansions
		if exp, exists := expansionsMap[color.ColorExpID]; exists {
			// Add the color to the expansion
			exp.Colors = append(exp.Colors, jsonColor)
		} else {
			log.Printf("Warning: Expansion ID %d not found for color %s", color.ColorExpID, color.ColorName)
		}

		colorsMap[color.ColorID] = &jsonColor
	}		
	
	



	// Marshal the data to JSON
	jsonData, err := json.MarshalIndent(jsonFormat, "", "  ")
	if err != nil {
		log.Fatal(err)
	}

	// Write the JSON data to a file
	if err := ioutil.WriteFile(outputFile, jsonData, 0644); err != nil {
		log.Fatal(err)
	}
}