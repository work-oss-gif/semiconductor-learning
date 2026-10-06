package com.semiconductor.learning;

/** All course text lives here. UI code lives in MainActivity. */
final class Content {

    private Content() {}

    /** One lesson: {title, body, question, options separated by |, index of right option, explanation}. */
    private static String[] l(String title, String body, String q, String options, int correct, String why) {
        return new String[] {title, body, q, options, String.valueOf(correct), why};
    }

    static final String[] GROUP_TITLES = {
        "1. The Basics",
        "2. Doping and the Diode",
        "3. Transistors",
        "4. Logic, Memory and Processors",
        "5. How Chips Are Made",
        "6. The Industry and the Future"
    };

    static final String[] GROUP_BLURBS = {
        "What semiconductors are and why silicon",
        "Making silicon controllable, and the one-way valve",
        "The tiny switch behind everything",
        "From switches to computers",
        "From sand to a finished chip",
        "Who makes chips, and what comes next"
    };

    static final String[][][] LESSONS = {
        // ---------------------------------------------------------------- 1. The Basics
        {
            l("What is a semiconductor?",
              "Materials fall into three groups by how well they let electric current through.\n\n"
              + "Conductors (copper) let current flow easily. Insulators (rubber) almost block it. "
              + "Semiconductors (silicon) sit in the middle.\n\n"
              + "Why is the middle useful? Because we can CONTROL it. By adding tiny amounts of other atoms, "
              + "or applying a voltage, we can make a semiconductor conduct or not conduct. "
              + "That on/off control is the foundation of every computer chip.",
              "Why are semiconductors so useful in electronics?",
              "They never conduct electricity|Their conductivity can be controlled|They conduct better than copper", 1,
              "Their conductivity can be controlled. Copper always conducts and rubber never does, "
              + "but a semiconductor can be switched between the two behaviours."),
            l("Atoms, electrons and energy bands",
              "Every atom has electrons. In a solid, electrons can only have certain energies, grouped into 'bands'.\n\n"
              + "Valence band: electrons stuck to their atoms, not free to carry current.\n"
              + "Conduction band: higher energy, where electrons can move freely and carry current.\n"
              + "Band gap: the energy gap between the two. An electron needs at least that much energy to jump up.\n\n"
              + "Conductors: no gap, so electrons move freely.\n"
              + "Insulators: a big gap, so almost nothing jumps.\n"
              + "Semiconductors: a small gap (silicon is about 1.1 electron-volts), so a modest push is enough.",
              "What is the band gap?",
              "The energy an electron needs to jump into the conduction band|A physical gap in the chip|The distance between two chips", 0,
              "The band gap is an energy step. Semiconductors have a small one, so heat, light or voltage can lift electrons across it."),
            l("Why silicon?",
              "Hundreds of materials are semiconductors, but silicon won because:\n\n"
              + "1. It is extremely cheap and abundant. Sand is mostly silicon dioxide.\n"
              + "2. Its band gap (about 1.1 eV) works well at room temperature.\n"
              + "3. It grows a natural, stable insulating layer: silicon dioxide (glass). "
              + "That layer is perfect for building transistors.\n"
              + "4. It can be purified to an incredible level and grown into huge perfect crystals.\n\n"
              + "The very first transistors used germanium, but silicon took over because of its stable oxide and low cost.",
              "Which natural property helped silicon beat germanium?",
              "It is magnetic|It forms a stable insulating oxide layer|It is the best conductor", 1,
              "Silicon dioxide forms easily on silicon and acts as a great insulator, which transistor makers rely on."),
            l("Electrons and holes",
              "In a semiconductor, current can be carried by two kinds of carriers:\n\n"
              + "Electrons: the negative charges that jumped into the conduction band.\n"
              + "Holes: the empty spots left behind. A neighbouring electron can hop in, so the hole seems to move "
              + "in the opposite direction, like a bubble in water.\n\n"
              + "Each time heat lifts an electron up, it creates one electron and one hole together.\n\n"
              + "Surprising fact: a semiconductor conducts BETTER when it gets warmer (more electrons jump the gap), "
              + "while a metal conducts slightly worse.",
              "What happens to a pure semiconductor's conductivity when it is heated?",
              "It goes up because more electrons jump the gap|It goes down to zero|It stays exactly the same", 0,
              "Heat gives electrons the energy to cross the band gap, creating more carriers."),
            l("Other semiconductor materials",
              "Silicon is not the only one. Different materials suit different jobs:\n\n"
              + "Germanium: used in early transistors.\n"
              + "Gallium arsenide (GaAs): fast, good at radio frequencies and light, used in some phone parts and lasers.\n"
              + "Silicon carbide (SiC): handles high voltage and heat, used in electric-car power systems.\n"
              + "Gallium nitride (GaN): efficient, used in fast chargers and blue LEDs.\n\n"
              + "Silicon still makes the vast majority of chips because it is cheap and well understood.",
              "Which material is common in efficient fast phone chargers?",
              "Gallium nitride (GaN)|Copper|Rubber", 0,
              "GaN switches power very efficiently, which allows small, cool, fast chargers.")
        },

        // ---------------------------------------------------------------- 2. Doping and the Diode
        {
            l("Doping: n-type and p-type",
              "Pure silicon conducts poorly. Doping means mixing in a very small number of foreign atoms "
              + "(roughly one in millions).\n\n"
              + "n-type: add phosphorus. It has one extra electron that is free to move. (n = negative carriers.)\n\n"
              + "p-type: add boron. It is missing an electron, which leaves a 'hole'. "
              + "Neighbouring electrons hop into the hole, so the hole moves like a positive charge. (p = positive.)\n\n"
              + "Neither type is electrically charged overall. The names describe the carriers, not a net charge.",
              "What is a 'hole' in p-type silicon?",
              "A physical drilled hole in the chip|A missing electron that acts like a positive carrier|An extra electron", 1,
              "A hole is a missing electron. Nearby electrons keep filling it, so the gap seems to travel."),
            l("Donors, acceptors and majority carriers",
              "The dopant atoms have names:\n\n"
              + "Donor (such as phosphorus): donates a free electron. Makes n-type silicon.\n"
              + "Acceptor (such as boron): accepts an electron, creating a hole. Makes p-type silicon.\n\n"
              + "In n-type silicon, electrons are the MAJORITY carriers and holes are the minority carriers. "
              + "In p-type it is the other way round.\n\n"
              + "Doping is powerful: a tiny amount can raise conductivity by a factor of a million or more. "
              + "That is why engineers control it so precisely.",
              "In p-type silicon, which carriers are the majority?",
              "Holes|Electrons|Neutrons", 0,
              "Acceptor atoms create holes, so holes dominate in p-type material."),
            l("Drift and diffusion",
              "Carriers move in two ways:\n\n"
              + "Drift: an electric field pushes them. Electrons go one way, holes the other.\n"
              + "Diffusion: carriers spread from where there are many to where there are few, "
              + "like perfume spreading through a room. No voltage is needed.\n\n"
              + "Both processes happen at once in every device. The p-n junction in the next lesson "
              + "is a balance between them.",
              "Which movement needs no applied voltage?",
              "Diffusion, spreading from crowded to empty areas|Drift|Neither can happen", 0,
              "Diffusion is driven by differences in concentration, just like a drop of ink spreading in water."),
            l("The p-n junction",
              "Join p-type and n-type silicon and something clever happens at the border.\n\n"
              + "Electrons from the n side diffuse across and fill holes on the p side. "
              + "This leaves a thin zone with almost no free carriers, called the depletion region.\n\n"
              + "The leftover fixed charges form an electric field that pushes back, until the diffusion stops. "
              + "The result is a built-in barrier of about 0.6 to 0.7 volts in silicon.\n\n"
              + "This single junction is the heart of diodes, LEDs, solar cells and transistors.",
              "What is the depletion region?",
              "A thin zone at the junction with almost no free carriers|The metal pin of the chip|A very hot area", 0,
              "Carriers cancel each other at the border, leaving a zone 'depleted' of free charge."),
            l("The diode",
              "A diode is a p-n junction with two connections, and it works as a one-way valve for current.\n\n"
              + "Forward bias (positive to the p side): the barrier shrinks. Once the voltage reaches about 0.7 V "
              + "in silicon, current flows freely.\n\n"
              + "Reverse bias (positive to the n side): the depletion region widens and almost no current flows.\n\n"
              + "Uses: turning AC into DC (rectifying), protecting circuits from reversed batteries, "
              + "and picking signals out of radio waves.",
              "In which direction does a silicon diode mainly conduct?",
              "Forward, once about 0.7 V is applied|Reverse|Both directions equally", 0,
              "Forward bias lowers the barrier so current flows; reverse bias raises it so current is blocked."),
            l("LEDs, solar cells and photodiodes",
              "A p-n junction can talk to light.\n\n"
              + "LED: when electrons and holes meet and recombine, they release energy as light. "
              + "The band gap decides the colour. Blue LEDs need a wide gap, which is why GaN was key.\n\n"
              + "Solar cell: the reverse. Light creates electron-hole pairs, and the junction's field "
              + "pushes them apart, producing current.\n\n"
              + "Photodiode: a junction used to detect light, such as in camera sensors and remote controls.",
              "What decides the colour of an LED?",
              "The band gap of the material|The size of the battery|The room temperature only", 0,
              "The energy released when an electron falls across the gap sets the photon's colour."),
            l("Special diodes: Zener and Schottky",
              "Zener diode: designed to be used in reverse. At a set voltage it 'breaks down' in a controlled way, "
              + "which holds a voltage steady. Used as a simple voltage reference.\n\n"
              + "Schottky diode: a metal-semiconductor junction instead of p-n. "
              + "It has a lower forward drop (about 0.2 to 0.4 V) and switches very fast, "
              + "so it is common in power supplies and radio circuits.",
              "What is a Zener diode mainly used for?",
              "Holding a voltage steady|Making light|Storing data", 0,
              "A Zener breaks down at a precise voltage, so it clamps and regulates voltage.")
        },

        // ---------------------------------------------------------------- 3. Transistors
        {
            l("The transistor idea",
              "A transistor is a switch with no moving parts, controlled by electricity.\n\n"
              + "It has three connections. A small signal on one (the control) decides whether a larger current "
              + "flows between the other two.\n\n"
              + "Two big jobs:\n"
              + "Switch: fully on or fully off. This is how digital chips work.\n"
              + "Amplifier: a small change in input makes a large change in output. This is how radios and audio work.\n\n"
              + "The transistor was invented at Bell Labs in 1947 and replaced bulky, hot vacuum tubes.",
              "What replaced vacuum tubes in electronics?",
              "The transistor|The battery|The magnet", 0,
              "Transistors do the same switching and amplifying jobs but are tiny, cool, cheap and reliable."),
            l("The bipolar transistor (BJT)",
              "The BJT has three layers, like an NPN sandwich, with connections called emitter, base and collector.\n\n"
              + "A small current into the base allows a much larger current to flow from collector to emitter. "
              + "The output is roughly the base current multiplied by a gain.\n\n"
              + "BJTs are current-controlled and great for analogue amplifiers. "
              + "But they draw some control current all the time, so for huge digital chips another type won.",
              "What controls a BJT?",
              "A small current into the base|Light only|The outside temperature only", 0,
              "A little base current opens the path for a much bigger collector current."),
            l("The MOSFET",
              "The MOSFET is the transistor used in nearly all modern chips.\n\n"
              + "Parts: source, drain and gate. Between source and drain is a channel. "
              + "The gate sits on a thin insulating layer, so it uses voltage and almost no current.\n\n"
              + "Gate voltage on: an electric field draws carriers into the channel, and current flows (a '1').\n"
              + "Gate voltage off: the channel disappears, and no current flows (a '0').\n\n"
              + "Because the gate draws almost no current, billions of MOSFETs can sit on one chip without melting it.",
              "In a MOSFET, what controls whether current flows between source and drain?",
              "The voltage on the gate|The colour of the chip|The brand of the battery", 0,
              "The gate voltage creates or removes the channel, which makes the MOSFET a voltage-controlled switch."),
            l("NMOS and PMOS",
              "There are two flavours of MOSFET, mirror images of each other.\n\n"
              + "NMOS: channel of electrons. It turns ON when the gate is HIGH (positive).\n"
              + "PMOS: channel of holes. It turns ON when the gate is LOW.\n\n"
              + "Each is good at one thing. NMOS passes a strong '0' (connects to ground well). "
              + "PMOS passes a strong '1' (connects to the supply well). "
              + "Using both together is the next lesson's trick.",
              "When does an NMOS transistor turn on?",
              "When its gate is high|When its gate is low|Only in the dark", 0,
              "NMOS conducts with a high gate voltage; PMOS is the opposite."),
            l("CMOS: the power-saving trick",
              "CMOS pairs PMOS and NMOS transistors so that one is always off.\n\n"
              + "The simplest CMOS circuit is the inverter (a NOT gate):\n"
              + "Input high: NMOS on, PMOS off, output pulled to 0.\n"
              + "Input low: PMOS on, NMOS off, output pulled to 1.\n\n"
              + "Because one transistor is always off, there is almost no direct path from supply to ground "
              + "when the circuit is idle. Power is mostly used only while switching.\n\n"
              + "That is why CMOS made it possible to pack billions of transistors on a chip.",
              "Why is CMOS power-efficient?",
              "One of the pair is always off, so little current flows when idle|It uses no electricity at all|It runs on light", 0,
              "The PMOS and NMOS never conduct together in a steady state, so idle power is tiny."),
            l("Switch versus amplifier",
              "The same transistor can play two roles depending on how it is driven.\n\n"
              + "As a switch, it is pushed fully on or fully off. Digital chips work this way, "
              + "so the only things that matter are '0' and '1'. Noise is easily ignored.\n\n"
              + "As an amplifier, it is kept in the middle, where small input changes cause large output changes. "
              + "This gives smooth, continuous signals, needed for audio, radio and sensors.\n\n"
              + "Many real chips, such as phone radios, contain both kinds.",
              "Which role do digital logic chips use?",
              "Switch, fully on or fully off|Amplifier only|Light bulb", 0,
              "Digital logic only needs two clear states, so transistors are driven fully on or off."),
            l("FinFET and gate-all-around",
              "As transistors shrank, the gate lost control over a flat channel and current leaked even when 'off'.\n\n"
              + "FinFET: the channel is raised into a thin vertical fin and the gate wraps around three sides. "
              + "Better control, less leakage. Intel introduced it commercially around 2011.\n\n"
              + "Gate-all-around (GAA): the channel becomes stacked ribbons or wires with the gate surrounding all sides. "
              + "Used in the newest chip generations.\n\n"
              + "The pattern: to keep shrinking, engineers make the transistor three-dimensional.",
              "Why did transistors move from flat designs to FinFETs?",
              "To control leakage better as they got smaller|To make them bigger|For decoration", 0,
              "Wrapping the gate around the channel gives better control and less wasted current.")
        },

        // ---------------------------------------------------------------- 4. Logic, Memory and Processors
        {
            l("Bits and binary",
              "Computers use just two states: 0 and 1, called a bit. A transistor being off or on stores or represents it.\n\n"
              + "Group bits to represent bigger things:\n"
              + "8 bits = 1 byte, enough for a letter or a number up to 255.\n"
              + "Binary counting: 0, 1, 10, 11, 100, 101...\n\n"
              + "Photos, music and video are all long lists of bits. "
              + "Two clear states are easy and reliable to build with transistors, which is why digital won.",
              "How many bits make one byte?",
              "8|2|100", 0,
              "A byte is 8 bits, which gives 256 possible values."),
            l("Logic gates",
              "A logic gate is a tiny circuit of transistors that follows a rule.\n\n"
              + "NOT: flips the input. 0 becomes 1.\n"
              + "AND: output 1 only if BOTH inputs are 1.\n"
              + "OR: output 1 if EITHER input is 1.\n"
              + "NAND: the opposite of AND. Output 0 only if both inputs are 1.\n\n"
              + "Fun fact: NAND alone can build every other gate, so it is called a 'universal' gate. "
              + "Whole processors could be built from NAND gates only.",
              "What does an AND gate output when its inputs are 1 and 0?",
              "0|1|Both", 0,
              "AND needs both inputs to be 1, so 1 and 0 gives 0."),
            l("Adding numbers with gates",
              "Gates can do arithmetic. A half adder adds two single bits:\n\n"
              + "Sum = A XOR B (1 when exactly one input is 1).\n"
              + "Carry = A AND B (1 when both are 1).\n\n"
              + "Example: 1 + 1 gives sum 0 and carry 1, which is binary 10, meaning two.\n\n"
              + "Chain many adders together and you can add 64-bit numbers. "
              + "Subtraction, multiplication and everything else are built from the same ideas.",
              "What is 1 + 1 in binary?",
              "10|2|11", 0,
              "Binary 10 means two: a sum bit of 0 and a carry of 1."),
            l("Memory: SRAM, DRAM and flash",
              "Chips need to remember bits. Three main types:\n\n"
              + "SRAM: about six transistors per bit in a loop that holds its value. Very fast, "
              + "used for CPU caches. Uses a lot of space.\n"
              + "DRAM: one transistor plus a tiny capacitor per bit. Dense and cheaper, but the charge leaks, "
              + "so it must be refreshed constantly. Used for main memory (RAM).\n"
              + "Flash: stores charge that stays even with power off. Used in phones, USB sticks and SSDs. "
              + "Slower to write, but non-volatile.",
              "Which memory keeps data when the power is off?",
              "Flash|SRAM|DRAM", 0,
              "SRAM and DRAM lose their data without power. Flash traps charge that stays."),
            l("The processor (CPU)",
              "A CPU is a machine that follows instructions, billions per second.\n\n"
              + "Main parts:\n"
              + "ALU: does the math and logic.\n"
              + "Registers: a few ultra-fast storage slots.\n"
              + "Control unit: reads each instruction and tells the other parts what to do.\n"
              + "Cache: small, fast memory close by.\n\n"
              + "A clock signal ticks like a metronome. Each tick moves the work forward one step. "
              + "A 3 GHz chip ticks three billion times per second.",
              "What does the ALU do?",
              "Arithmetic and logic operations|Cools the chip|Stores your photos", 0,
              "ALU stands for arithmetic logic unit: it is where calculations happen."),
            l("GPUs and AI chips",
              "A CPU has a few powerful cores that handle varied tasks one after another.\n\n"
              + "A GPU has thousands of simpler cores that do the same operation on lots of data at once. "
              + "That suits graphics, and also the huge matrix maths used in AI.\n\n"
              + "AI chips add special units for matrix multiplication and use very fast stacked memory "
              + "(HBM) so data arrives quickly enough.\n\n"
              + "Rule of thumb: CPU for flexibility, GPU for parallel number-crunching.",
              "Why are GPUs good for AI?",
              "Thousands of cores can work on data in parallel|They are always cold|They have no memory", 0,
              "AI is mostly huge amounts of identical maths, which parallel cores handle well."),
            l("Moore's law",
              "In 1965 Gordon Moore noticed that the number of transistors on a chip was doubling regularly. "
              + "Later it settled at about every two years.\n\n"
              + "It is not a law of physics. It was an observation, and the industry treated it as a target.\n\n"
              + "Result: a modern phone chip holds billions of transistors, millions of times more than the early 1970s chips.\n\n"
              + "Today, shrinking is harder and costlier, so progress also comes from new transistor shapes, "
              + "stacking and smarter designs.",
              "What is Moore's law?",
              "An observation that transistor counts double about every two years|A law of physics|A government rule", 0,
              "It was a trend noticed by Gordon Moore that the industry worked hard to keep going.")
        },

        // ---------------------------------------------------------------- 5. How Chips Are Made
        {
            l("From sand to wafer",
              "1. Start with quartz sand (silicon dioxide) and refine it into pure silicon.\n"
              + "2. Purify it to extreme levels, with fewer than one foreign atom per billion.\n"
              + "3. Melt it and slowly pull a rotating seed crystal out (the Czochralski method). "
              + "This grows a single perfect crystal called an ingot.\n"
              + "4. Saw the ingot into thin discs and polish them mirror-smooth. These are wafers.\n\n"
              + "Common wafers are 300 mm (about 12 inches) wide. Many hundreds of chips are made on one wafer at once.",
              "What is a wafer?",
              "A thin polished disc of silicon crystal|A kind of biscuit|A finished phone", 0,
              "Wafers are the base on which many chips are built at the same time."),
            l("The cleanroom",
              "Chips have features thousands of times smaller than a dust speck, so fabs are cleaner than hospitals.\n\n"
              + "Workers wear full 'bunny suits'. Air is filtered constantly and flows downward. "
              + "Many machines move wafers in sealed boxes so they never touch room air.\n\n"
              + "Why so strict? One dust particle on a wafer can ruin a chip, "
              + "and each wafer may be worth thousands of dollars by the end.",
              "Why must chip factories be so clean?",
              "A tiny particle can ruin a chip|For looks|So the staff stay warm", 0,
              "Features are microscopic, so even one speck can break a circuit."),
            l("Photolithography",
              "This is how the circuit pattern is printed. It works like a photo enlarger in reverse.\n\n"
              + "1. Coat the wafer with a light-sensitive layer called photoresist.\n"
              + "2. Shine light through a patterned stencil (the mask or reticle).\n"
              + "3. The light shrinks the pattern through lenses and exposes the resist.\n"
              + "4. Develop it: either the exposed or the unexposed parts wash away.\n\n"
              + "The pattern is now a stencil on the wafer, ready for the next step. "
              + "A modern chip repeats this process dozens of times, once for each layer.",
              "What is photoresist?",
              "A light-sensitive coating|A kind of metal|A cooling liquid", 0,
              "Light changes the resist so the pattern can be developed into a stencil."),
            l("EUV: printing the tiniest details",
              "Smaller features need light of shorter wavelength. Older machines used deep ultraviolet at 193 nm.\n\n"
              + "EUV (extreme ultraviolet) uses 13.5 nm light, which is far shorter.\n\n"
              + "Making it is wild: tiny tin droplets are fired and hit by a powerful laser, "
              + "turning each into a hot plasma that gives off EUV. "
              + "EUV is absorbed by air and glass, so everything happens in a vacuum and uses mirrors, not lenses.\n\n"
              + "Only one company, ASML in the Netherlands, builds these machines. Each costs hundreds of millions.",
              "Why does EUV use mirrors instead of lenses?",
              "EUV light is absorbed by glass and air|Mirrors are cheaper|Lenses are too heavy", 0,
              "EUV is absorbed by almost everything, so it works in a vacuum with reflective optics."),
            l("Etching, deposition and implantation",
              "After the pattern is printed, other steps build the transistor:\n\n"
              + "Etching: remove material where the stencil leaves it exposed, like carving.\n"
              + "Deposition: add thin layers of insulator or metal, by chemical vapour or by sputtering.\n"
              + "Ion implantation: fire dopant atoms into the silicon at high speed to create n-type and p-type regions.\n"
              + "Polishing (CMP): flatten the surface so the next layer sits evenly.\n\n"
              + "A chip is built by repeating print, etch, deposit, dope and polish many times.",
              "What does ion implantation do?",
              "Places dopant atoms into the silicon|Cuts the wafer apart|Cleans the wafer", 0,
              "Ions of boron, phosphorus and others are shot in to set the doping exactly where needed."),
            l("Wiring and process nodes",
              "Once transistors are formed, many layers of copper wiring connect them, "
              + "stacked like a tiny multi-storey road system. Modern chips can have over a dozen metal layers.\n\n"
              + "Process nodes: names like '5 nm' or '3 nm' label a generation of manufacturing. "
              + "Today they are mostly marketing names and no longer match a real measured size. "
              + "Smaller numbers still generally mean more transistors per area and better efficiency.\n\n"
              + "Comparing two companies' nodes by the number alone can mislead.",
              "What does a node name like '3 nm' mean today?",
              "A generation label, not an exact measured length|The exact width of every transistor|The chip's price", 0,
              "The numbers are brand-like labels. They show progress but do not equal a real dimension."),
            l("Packaging, testing and yield",
              "1. Test the chips while still on the wafer and mark the bad ones.\n"
              + "2. Cut the wafer into individual pieces called dies.\n"
              + "3. Package each good die: mount it, connect its tiny pads to pins or balls, "
              + "and seal it with a protective case.\n"
              + "4. Final testing under heat and cold.\n\n"
              + "Yield is the percentage of chips that work. A larger chip is more likely to catch a defect, "
              + "so yield drops with size. Good yield is the difference between profit and loss for a fab.",
              "What is 'yield'?",
              "The percentage of chips that work|The size of the wafer|How fast the chip runs", 0,
              "Higher yield means more sellable chips from each expensive wafer.")
        },

        // ---------------------------------------------------------------- 6. The Industry and the Future
        {
            l("Who makes chips?",
              "The industry has different business models:\n\n"
              + "Fabless: designs chips but owns no factory. Examples: Nvidia, AMD, Qualcomm, Apple's chip team.\n"
              + "Foundry: builds chips for other companies. Example: TSMC.\n"
              + "IDM (integrated device maker): designs and builds its own. Examples: Intel, Samsung (which is also a foundry), Texas Instruments.\n\n"
              + "Factories cost tens of billions of dollars, so many companies choose to design only.",
              "What does a 'fabless' company do?",
              "Designs chips but has others build them|Builds chips but never designs them|Sells only cables", 0,
              "Fabless firms avoid the huge cost of factories by using foundries."),
            l("The supply chain",
              "Making one chip needs many specialist companies across the world:\n\n"
              + "Design software (EDA) and ready-made design blocks (IP, such as Arm).\n"
              + "Equipment makers: lithography (ASML), etching and deposition tools.\n"
              + "Materials: ultra-pure silicon wafers, chemicals, gases.\n"
              + "Fabs that manufacture, then packaging and testing houses.\n\n"
              + "A single chip may cross borders many times before it reaches a device. "
              + "A problem in any link, such as a shortage, can stall whole industries, as seen in 2021.",
              "Why can one shortage disrupt many industries?",
              "Chips depend on a long chain of specialist suppliers|Chips are made from one ingredient only|Chips are not used in cars", 0,
              "The chain is long and specialised, so a gap anywhere slows the final product."),
            l("Chips everywhere",
              "Semiconductors are in far more than computers:\n\n"
              + "Phones: processor, memory, radios, camera sensors, power chips.\n"
              + "Cars: modern cars hold hundreds or even thousands of chips for engines, brakes, screens and driver assistance.\n"
              + "Home: washing machines, TVs, smart speakers, LED bulbs.\n"
              + "Industry and health: robots, scanners, pacemakers, solar inverters.\n\n"
              + "Many of these chips are not cutting-edge. Older, cheaper nodes still produce a large share of everyday chips.",
              "Do all chips need the newest, smallest process?",
              "No, many everyday chips use older, cheaper processes|Yes, always|No chips are used in cars", 0,
              "A car's window controller does not need a 3 nm chip. Older nodes are cheaper and perfectly good."),
            l("Power semiconductors",
              "Not every chip computes. Power devices switch large currents and voltages and manage energy.\n\n"
              + "They are used in phone chargers, electric cars, solar inverters and train drives.\n\n"
              + "Key idea: every time energy is converted, some is lost as heat. Better devices lose less. "
              + "Silicon carbide and gallium nitride lose less than plain silicon at high voltage and speed, "
              + "which extends electric-car range and shrinks chargers.",
              "Why are SiC and GaN valued in power electronics?",
              "They waste less energy as heat|They are cheaper than sand|They glow in the dark", 0,
              "Lower switching losses mean higher efficiency, smaller parts and longer battery range."),
            l("Chiplets and 3D stacking",
              "Giant single chips are hard to make with good yield. Two answers are growing:\n\n"
              + "Chiplets: split a design into smaller dies and join them in one package. "
              + "Small dies yield better, and you can mix old and new technology.\n\n"
              + "3D stacking: place dies on top of each other with very short vertical connections. "
              + "Stacked memory (HBM) beside AI processors is a famous example.\n\n"
              + "These advanced packaging methods are becoming as important as shrinking transistors.",
              "What is a chiplet?",
              "A smaller die combined with others in one package|A broken chip|A very small battery", 0,
              "Building from several small dies improves yield and lets designers mix technologies."),
            l("The future of semiconductors",
              "Where could things go next?\n\n"
              + "More 3D: stacked transistors and layers.\n"
              + "New materials: 2D materials like graphene-like sheets, and better channel materials.\n"
              + "Specialised chips: designs tailored for AI, video or networking instead of general chips.\n"
              + "Light on chips: photonics to move data using light.\n"
              + "Better energy use: the big limit now is heat and power, not just size.\n\n"
              + "You now know the full path: atoms, doping, diodes, transistors, logic, manufacturing and industry. "
              + "Well done!",
              "What is a big limit on progress today besides size?",
              "Heat and power use|The colour of silicon|A lack of binary numbers", 0,
              "Packing more transistors makes more heat, so energy efficiency is central to future designs.")
        }
    };
}
