# JMETER Timer

"Timer" Test elements is pausing a JMeter
thread representing a virtual user for a certain
amount time.

Main goal of using timers is simulating a virtual user's
"think time".

High Level overview of how JMeter works looks as follow:

- When a Test Plan is started, JMeter kicks off a thread per virtual user
- Each Thread starts executing samplers upside down(or use logical controller)
- No samplers or loops to execute,thread shutdown.

## Timer Scope and Processing

- All Timer will be processed before sampler occurs
- Timer pauses is not recorded
- 

