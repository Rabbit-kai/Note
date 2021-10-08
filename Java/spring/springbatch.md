# Job

Job是Spring Batch编程层面的定义
		Joblnstance是一个Spring Batch Job模板，包含Job名称以及实例ID
		JobExecution是Spring Batch Job执行对象，包含JobInstance以及JobParameters
		Joblnstance与JobExecution是一对多的关系

## Joblnstance

●JobInstance是-一个Spring Batch Job模板，包含Job名称以及实例ID
		●JobInstance与JobExecution是一对多的关系,是物理关联，JobExecution 存在的前提是JobInstance必须存在
		●Job与JobInstance是一对一，是逻辑关联



## JobParameters

●默认情况, JobParameters 包含-个空Key-Value 结构，即Key为String类型，Value 为JobParameter类型，可以通过调整数据库的方式来设置JobParameters,从而影响调度

●表达式逻辑: JobExecution = JobInstance + JobParameters
		●JobParameters = N个JobParameter

●JobParameter 的值存在四种数据类型
			。字符型: String
			。日期类型: Date
			。整数类型: Long
			。小数类型: Double

●在Spring Batch默认实现中，JobParameter 对应的关系型数据库的表为: "BATCH. JOB_ _EXECUTION_ PARAMS", 它与数据表"BATCH. JOB_ EXECUTION"存在多对-的关系
			。BATCH_ JOB_ INSTANCE 对BATCH_ JOB_ EXECUTION 是1 :N
			。BATCH. JOB_ _EXECUTION对BATCH_ JOB_EXECUTION_PARAMS是1 :M
			。BATCH_ JOB_ INSTANCE: BATCH_ JOB_ _EXECUTION_ PARAMS是1 :M* N
		●JobParameters默认情况是空JobParameter集合
		●JobParameters 是Joblauncher的执行参数

```java
public interface JobLanucher {
	public JobExecution run(Job job， JobParaneters jobParameters) throws .. 。
}
```



# JobLauncher

JobLauncher这个接口的功能非常简单，它是用于启动指定了JobParameters的Job，为什么这里要强调指定了JobParameter，原因其实我们在前面已经提到了，jobparameter和job一起才能组成一次job的执行。下面是代码实例：

```java
public interface JobLauncher {

public JobExecution run(Job job, JobParameters jobParameters)
            throws JobExecutionAlreadyRunningException, JobRestartException,
                   JobInstanceAlreadyCompleteException, JobParametersInvalidException;
}
```

上面run方法实现的功能是根据传入的job以及jobparamaters从JobRepository获取一个JobExecution并执行Job

# chunk 处理流程

spring batch提供了让我们按照chunk处理数据的能力，一个chunk的示意图如下：

![img](https://img-blog.csdnimg.cn/20190110100140602.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3RvcGRldmVsb3BlcnI=,size_16,color_FFFFFF,t_70)

它的意思就和图示的一样，由于我们一次batch的任务可能会有很多的数据读写操作，因此一条一条的处理并向数据库提交的话效率不会很高，因此spring batch提供了chunk这个概念，我们可以设定一个chunk size，spring batch 将一条一条处理数据，但不提交到数据库，只有当处理的数据数量达到chunk size设定的值得时候，才一起去commit.

java的实例定义代码如下：

![image-20210819100417082](E:\Note\Java\spring\springbatch.pic\image-20210819100417082.png)

在上面这个step里面，chunk size被设为了10，当ItemReader读的数据数量达到10的时候，这一批次的数据就一起被传到itemWriter，同时transaction被提交。



# skip策略和失败处理

一个batch的job的step，可能会处理非常大数量的数据，难免会遇到出错的情况，出错的情况虽出现的概率较小，但是我们不得不考虑这些情况，因为我们做数据迁移最重要的是要保证数据的最终一致性。spring batch当然也考虑到了这种情况，并且为我们提供了相关的技术支持，请看如下bean的配置：

![image-20210819100606066](E:\Note\Java\spring\springbatch.pic\image-20210819100606066.png)

我们需要留意这三个方法，分别是skipLimit(),skip(),noSkip(),

skipLimit方法的意思是我们可以设定一个我们允许的这个step可以跳过的异常数量，假如我们设定为10，则当这个step运行时，只要出现的异常数目不超过10，整个step都不会fail。注意，若不设定skipLimit，则其默认值是0.

skip方法我们可以指定我们可以跳过的异常，因为有些异常的出现，我们是可以忽略的。

noSkip方法的意思则是指出现这个异常我们不想跳过，也就是从skip的所以exception当中排除这个exception，从上面的例子来说，也就是跳过所有除FileNotFoundException的exception。那么对于这个step来说，FileNotFoundException就是一个fatal的exception，抛出这个exception的时候step就会直接fail



# ItemReader



# BaseListReader









