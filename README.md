# CFG-LR
Left Recursion Elimination for Context Free Grammars (CFG) implementation in java. 

### 1. Objective
In this project the context-free grammar (CFG) left-recursion elimination
algorithm was implemented. 

Recall that a CFG is a quadruple (V, Σ, R, S)
where V and Σ are disjoint alphabets (respectively, containing variables and terminals), R ⊆
V × (V ∪ Σ)∗
is a set of rules, and S ∈ V is the start variable.

### 2 Requirements
- We make the following assumptions about input CFGs for simplicity.
  * The set V of variables consists of upper-case English symbols.
  * The start variable is the symbol S.
  * The set Σ of terminals consists of lower-case English symbols (except the letter e).
  * We only consider CFGs with no cycles and no ε-rules.
- A function LRE which takes an input string encoding a CFG and returns a string encoding an equivalent CFG which is not left-recursive is implemented.
- A string encoding a CFG is a semi-colon separated sequence of items. Each item represents a largest set of rules with the same left-hand side and is a comma-separated
sequence of strings. The first string of each item is a member of V , representing the
common left-hand side. The first string of the first item is S.


For example, consider the CFG ({S, T, L}, {i, a, b, c, d}, R, S), where R is given by the
following productions.

```
S −→ S c T | S a | T | b
T −→ a S b | i a L b | i
L −→ S d L | S
```

  This CFG will have the following string encoding, *spaces are added for the ease of reading*. 

> **S, ScT, Sa, T, b; T, aSb, iaLb, i; L, SdL, S**


- The function LRE will assume the ordering of variables as they appear in the string
encoding of the CFG. Thus, in the above example, the variables are ordered thus: S, T, L.
- LRE returns a string encoding the resulting CFG where a newly-introduced variable, for
the elimination of immediate left-recursion for variable A, is the string A. The letter e
denotes the empty string.
- Thus, for the above example, the output should be as follows, *spaces are added for the ease of reading*. 

S, =TS0 , bS0 ; S0, cTS0, aS0, e; T, aSb, iaLb, i;L, aSbS0dL, iaLbS0dL, iS0dL, bS0dL, aSbS0, iaLbS0, iS0, bS0


