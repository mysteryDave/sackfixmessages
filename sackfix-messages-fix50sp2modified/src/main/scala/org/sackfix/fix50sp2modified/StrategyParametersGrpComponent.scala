package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class StrategyParametersGrpComponent(noStrategyParametersField:Option[NoStrategyParametersField]=None,
                                          strategyParametersGroups: Option[List[StrategyParametersGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noStrategyParametersField.map(_.value).getOrElse(0) != strategyParametersGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoStrategyParametersField.TagId,noStrategyParametersField.map(_.value).getOrElse(0), strategyParametersGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noStrategyParametersField.foreach(fmt(b,_))
    strategyParametersGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object StrategyParametersGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    StrategyParametersGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoStrategyParametersField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    StrategyParametersGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    StrategyParametersGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoStrategyParametersField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = StrategyParametersGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[StrategyParametersGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(StrategyParametersGrpComponent(myFields.get(NoStrategyParametersField.TagId).flatMap(f=>NoStrategyParametersField.decode(f)),
        if (nextTagPosLookup.contains(NoStrategyParametersField.TagId)) StrategyParametersGroup.decode(flds, nextTagPosLookup(NoStrategyParametersField.TagId)) else None))
    } else None
  }

    
}
     