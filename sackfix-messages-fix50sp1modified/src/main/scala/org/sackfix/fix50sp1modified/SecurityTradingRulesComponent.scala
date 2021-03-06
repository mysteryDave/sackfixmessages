package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class SecurityTradingRulesComponent(baseTradingRulesComponent:Option[BaseTradingRulesComponent]=None,
                                         tradingSessionRulesGrpComponent:Option[TradingSessionRulesGrpComponent]=None,
                                         nestedInstrumentAttributeComponent:Option[NestedInstrumentAttributeComponent]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    baseTradingRulesComponent.foreach(fmt(b,_))
    tradingSessionRulesGrpComponent.foreach(fmt(b,_))
    nestedInstrumentAttributeComponent.foreach(fmt(b,_))
    b
  }

}
     
object SecurityTradingRulesComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    BaseTradingRulesComponent.isMandatoryField(tagId) || TradingSessionRulesGrpComponent.isMandatoryField(tagId) || NestedInstrumentAttributeComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int]()

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    BaseTradingRulesComponent.isOptionalField(tagId) || TradingSessionRulesGrpComponent.isOptionalField(tagId) || NestedInstrumentAttributeComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    BaseTradingRulesComponent.isFieldOf(tagId) || TradingSessionRulesGrpComponent.isFieldOf(tagId) || NestedInstrumentAttributeComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = BaseTradingRulesComponent.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SecurityTradingRulesComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(SecurityTradingRulesComponent(BaseTradingRulesComponent.decode(flds, startPos),
        TradingSessionRulesGrpComponent.decode(flds, startPos),
        NestedInstrumentAttributeComponent.decode(flds, startPos)))
    } else None
  }

    
}
     