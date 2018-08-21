package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class TradingSessionRulesGrpComponent(noTradingSessionRulesField:Option[NoTradingSessionRulesField]=None,
                                           tradingSessionRulesGroups: Option[List[TradingSessionRulesGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noTradingSessionRulesField.map(_.value).getOrElse(0) != tradingSessionRulesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoTradingSessionRulesField.TagId,noTradingSessionRulesField.map(_.value).getOrElse(0), tradingSessionRulesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noTradingSessionRulesField.foreach(fmt(b,_))
    tradingSessionRulesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object TradingSessionRulesGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    TradingSessionRulesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoTradingSessionRulesField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    TradingSessionRulesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    TradingSessionRulesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoTradingSessionRulesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = TradingSessionRulesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[TradingSessionRulesGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(TradingSessionRulesGrpComponent(myFields.get(NoTradingSessionRulesField.TagId).flatMap(f=>NoTradingSessionRulesField.decode(f)),
        if (nextTagPosLookup.contains(NoTradingSessionRulesField.TagId)) TradingSessionRulesGroup.decode(flds, nextTagPosLookup(NoTradingSessionRulesField.TagId)) else None))
    } else None
  }

    
}
     