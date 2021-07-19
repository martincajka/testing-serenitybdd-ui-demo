Feature: Find train connection
  In order to choose best train connection in Slovakia
  As a foreign tourist
  I want to look for the one that satisfies all expectations

  Scenario: Find the first train from Bratislava to Kosice
    Given that "John" decides to search for train connection
    When he searches for train from "Bratislava hl.st." to "Košice"
    Then he should see only valid connections with departure later than current time for selected route
